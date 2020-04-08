package com.bigcat.app.service.impl;

import com.bigcat.app.dao.BetsOrderMapper;
import com.bigcat.app.dao.FinanceMapper;
import com.bigcat.app.dao.PlayerMapper;
import com.bigcat.app.pojo.*;
import com.bigcat.app.utils.ConstantUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class FinanceService {

    @Autowired
    private FinanceMapper financeMapper;

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private TemplateService templateService;

    @Autowired
    private BetsOrderService betsOrderService;

    @Autowired
    private BetsOrderMapper betsOrderMapper;


    /**
     * 计算盈亏
     * @return
     */
    public BigDecimal calculationProfitAndLoss(String gameId,long beginPeriod, long endPeriod){
        BetsOrderExample example = new BetsOrderExample();
        BetsOrderExample.Criteria criteria = example.createCriteria();
        if(beginPeriod == endPeriod){
            criteria.andPeriodEqualTo(beginPeriod);
        }else{
            criteria.andGameIdEqualTo(gameId)
                    .andPeriodBetween(beginPeriod,endPeriod);
        }

        List<BetsOrder> betsOrders = betsOrderMapper.selectByExample(example);
        Optional<BigDecimal> totalProfitAndLoss = betsOrders.stream().map(ele -> {
            Finance betsFinance = financeMapper.selectByPrimaryKey(ele.getFinanceId());
            Finance resultFinance = financeMapper.selectByPrimaryKey(ele.getResultFinanceId());
            BigDecimal profitAndLoss = resultFinance.getMoney().subtract(betsFinance.getMoney());
            return profitAndLoss;
        }).reduce((x, y) -> x.add(y));

        return totalProfitAndLoss.get();
    }

    public BigDecimal calculationProfitAndLoss(BetsOrder order){
        Finance betsFinance = financeMapper.selectByPrimaryKey(order.getFinanceId());
        Finance resultFinance = financeMapper.selectByPrimaryKey(order.getResultFinanceId());
        BigDecimal profitAndLoss = resultFinance.getMoney().subtract(betsFinance.getMoney().abs());
        return profitAndLoss;
    }



    /**
     * 添加财务记录，并修改用户余额。发送余额变动消息自定义
     * @param type
     * @param player
     * @param status
     * @param money
     * @return
     */
    public Finance add(Integer type, Player player, Integer status, BigDecimal money){

        Finance finance = new Finance();
        finance.setId(UUID.randomUUID().toString());
        finance.setType(type);
        finance.setCreateTime(new Date());
        finance.setPlayerId(player.getId());
        finance.setStatus(status);
        finance.setMoney(money);

        String moneyStr = money.toString();
        if(money.compareTo(new BigDecimal(0)) == -1){
            moneyStr = money.abs().toString();
        }
        finance.setRemark(StringUtils.join("[",player.getNickname(),"]", ConstantUtils.FinanceType.getName(type),":",moneyStr));

        financeMapper.insert(finance);

        player.setBalance(player.getBalance()==null?new BigDecimal(0).add(money):player.getBalance().add(money));
        playerMapper.updateByPrimaryKeySelective(player);

        return finance;
    }





}
