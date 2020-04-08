package com.bigcat.app.controller;

import com.bigcat.app.dao.FinanceMapper;
import com.bigcat.app.dto.Template;
import com.bigcat.app.pojo.Finance;
import com.bigcat.app.pojo.FinanceExample;
import com.bigcat.app.pojo.Player;
import com.bigcat.app.service.impl.FinanceService;
import com.bigcat.app.service.impl.TemplateService;
import com.bigcat.app.utils.AppUtils;
import com.bigcat.app.utils.ConstantUtils;
import com.bigcat.app.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    private FinanceService financeService;
    @Autowired
    private FinanceMapper financeMapper;
    @Autowired
    private TemplateService templateService;

    /**
     *  审核上下分
     * @param financeId 财务id
     * @param status 2=审核通过 -1=拒绝
     * @param type  1=上分 2=下分
     * @param ignore 1 = 发送拒绝上分消息到客户端。-1=不发送。2=删除全部上下分消息
     * @return
     */
    @GetMapping("/examine")
    public RestResult examine(@RequestParam(defaultValue = "") String financeId,
                              @RequestParam(defaultValue = "-1") Integer status,
                              @RequestParam(defaultValue = "-1") Integer type,
                              @RequestParam(defaultValue = "-1") Integer ignore){

        if(ignore.equals(2)){
            FinanceExample example = new FinanceExample();
            example.createCriteria()
                    .andStatusEqualTo(ConstantUtils.FinanceStatus.NotExamine.index)
                    .andTypeEqualTo(type);
            financeMapper.deleteByExample(example);
            return RestResult.build();
        }

        Finance finance = financeMapper.selectByPrimaryKey(financeId);
        if(finance == null){
            throw new RuntimeException("该财务信息不存在");
        }
        Player player = AppUtils.getPlayer(finance.getPlayerId());


        if(finance == null)
            throw new RuntimeException("finance is null");

        finance.setStatus(status);

        Template template = null;
        if(status.equals(ConstantUtils.FinanceStatus.Examine.index)){
            financeMapper.updateByPrimaryKeySelective(finance);
            if(type.equals(ConstantUtils.FinanceType.UpperScore.index))
                template = templateService.buildTemplate(ConstantUtils.UPPER_SCORE_SUCCESS, player);
            else
                template = templateService.buildTemplate(ConstantUtils.LOWER_SCORE_SUCCESS, player);
        }else{
            financeMapper.deleteByPrimaryKey(finance.getId());
            if(ignore.equals(1) && type.equals(ConstantUtils.FinanceType.UpperScore.index)){
                template = templateService.buildTemplate(ConstantUtils.UPPER_SCORE_FAIL, player);
            }
        }


        return RestResult.build().map().put("template",template)
                                       .put("account",player.getAccount())
                                       .put("nickname",player.getNickname())
                                       .put("source",player.getSource());
    }


    @GetMapping("/monitor")
    public RestResult find(@RequestParam(defaultValue = "0") int sort,
                           @RequestParam(defaultValue = "0") long period,
                           @RequestParam(defaultValue = "")  String gameId){



        return RestResult.build();
    }


}
