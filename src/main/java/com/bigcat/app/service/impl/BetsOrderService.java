package com.bigcat.app.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bigcat.app.dao.BetsOrderMapper;
import com.bigcat.app.dto.*;
import com.bigcat.app.pojo.*;
import com.bigcat.app.socket.exception.ClientException;
import com.bigcat.app.utils.AppUtils;
import com.bigcat.app.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class BetsOrderService {

    @Autowired
    private FinanceService financeService;
    @Autowired
    private TemplateService templateService;


    /**
     * 根据状态查询指定game和期号的注单
     * @param status
     * @param period
     * @param gameId
     * @return
     */
    public List<BetsOrder> findByStatus(int status,long period,String gameId){
        BetsOrderExample example = new BetsOrderExample();
        example.createCriteria().andStatusEqualTo(status)
                .andPeriodEqualTo(period).andGameIdEqualTo(gameId);

        return getMapper().selectByExample(example);
    }

    public List<BetsOrder> findByPlayer(String playerId,long period , String gameId){
        BetsOrderExample orderExample = new BetsOrderExample();
        orderExample.createCriteria().andPlayerIdEqualTo(playerId)
                .andPeriodEqualTo(period)
                .andGameIdEqualTo(gameId);

        List<BetsOrder> betsOrders = getMapper().selectByExample(orderExample);
        if(betsOrders.size()>0){
            return betsOrders;
        }else{
            return null;
        }
    }

    /**
     *  生成订单
     * @param money    该订单投注的金额
     * @param playerIn 输入的指令
     * @return
     */
    public BetsOrder generator(Player player , BigDecimal money,
                               String playerIn , String gameId,
                               Long period , String targetWay , String data){

        // 订单财务
        Finance finance = financeService.add(ConstantUtils.FinanceType.BetsOrder.index,
                player, ConstantUtils.FinanceStatus.Examine.index,money);
        // 订单
        BetsOrder betsOrder = new BetsOrder();
        betsOrder.setId(UUID.randomUUID().toString());
        betsOrder.setPlayerId(player.getId());
        betsOrder.setPlayerIn(playerIn);
        betsOrder.setStatus(ConstantUtils.BetsOrderStatus.NotSettled.index);
        betsOrder.setData(data);
        betsOrder.setGameId(gameId);
        betsOrder.setPeriod(period);
        betsOrder.setFinanceId(finance.getId());
        betsOrder.setCreateTime(new Date());
        betsOrder.setTargetWay(targetWay);
        betsOrder.setBetsMoney(money);

        AppUtils.support.getBetsOrderMapper().insert(betsOrder);

        return betsOrder;
    }


    /**
     * 结算一组订单
     * @return 返回中奖人的财务信息
     */
    public void settlementOrder(OpenRecord record,String gameCode){

        BetsOrderMapper mapper = AppUtils.support.getBetsOrderMapper();

        BetsOrderExample example = new BetsOrderExample();
        BetsOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPeriodEqualTo(record.getPeriod())
                .andGameIdEqualTo(record.getGameid())
                .andStatusEqualTo(ConstantUtils.BetsOrderStatus.NotSettled.index);

        List<BetsOrder> betsOrders = mapper.selectByExample(example);
        betsOrders.stream().forEach(ele->{
            settlement(ele,record.getResult(),gameCode);
        });
    }

    /**
     * 结算注单
     */
    public void settlement(BetsOrder order , String result , String gameCode){
        try {
            Map<String, Object> data = new HashMap<>();

            data.put("result",result);
            data.put("money",order.getBetsMoney());
            data.put("data",JSONObject.parseObject(order.getData(),Map.class));
            data.put("player",AppUtils.getPlayer(order.getPlayerId()));

            Object o = ConstantUtils.gateWay.gateWay(gameCode + order.getTargetWay(), data);
            if(o instanceof  Finance){
                Finance finance = (Finance) o;
                order.setResultFinanceId(finance.getId());
                order.setStatus(ConstantUtils.BetsOrderStatus.Settled.index);
                BetsOrderExample example = new BetsOrderExample();
                example.createCriteria().andIdEqualTo(order.getId());
                getMapper().updateByExampleSelective(order,example);
            }
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }


    public TemplateResponse betsOrder(Player player, BetsOrderDto dto){

        TemplateResponse response = new TemplateResponse();
        GlobalCacheInfo info = GlobalCacheInfo.getInfo();
        String gameId = info.getGameId();
        // 判断是否封盘
        if(ConstantUtils.RunState.Stop.index.equals(info.getGameStage())){

            Template template = templateService
                    .buildTemplate(ConstantUtils.BETS_FAIL_STOP_BETS, player);

            response.setTemplate(template);
            throw new ClientException("投注失败，已封盘",response);
        }

        List<BetsOrderItemDto> orders = dto.getOrders();
        if(orders != null){

            // 计算余额是否不足
            Optional<Integer> totalMoney = orders.stream()
                    .map(ele -> ele.getMoney())
                    .reduce((x, y) -> x + y);

            if(player.getBalance().compareTo(new BigDecimal(totalMoney.get())) == -1){
                Map<String, String> map = new HashMap<>();
                map.put("{下单}",dto.getPlayerIn());
                Template template = templateService
                        .buildTemplate(ConstantUtils.BETS_FAIL_BALANCE_SHORT_OF, player, map);


                response.setTemplate(template);
                throw new ClientException("投注余额不足",response);
            }

            // 保存订单
            orders.forEach(ele->generator(player,new BigDecimal(ele.getMoney()).negate(),
                                          ele.getPlayerIn(), gameId,GlobalCacheInfo.getInfo().getNextPeriod(),
                                          ele.getName(),ele.getData()!=null?JSONObject.toJSONString(ele.getData()):null));
        }

        // 返回模板
        Map<String, String> map = new HashMap<>();
        map.put("{下单}",dto.getPlayerIn());
        Template template = templateService
                .buildTemplate(ConstantUtils.BETS_ORDER_SUCCESS_TIPS, player, map);

        response.setTemplate(template);

        return response;
    }



    public BetsOrderMapper getMapper(){
        return AppUtils.support.getBetsOrderMapper();
    }


}






















































