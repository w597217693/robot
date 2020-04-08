package com.bigcat.app.controller;

import com.bigcat.app.pojo.Way;
import com.bigcat.app.pojo.WayExample;
import com.bigcat.app.utils.AppUtils;
import com.bigcat.app.utils.RestResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/way")
public class WayController {

    @GetMapping
    public RestResult findAll(){

        List ways = AppUtils.support.getWayMapper().selectByExample(new WayExample());

        return RestResult.build().map()
                .put("title","投注")
                .put("path","/message/order-bets")
                .put("ways",ways);
    }

    @GetMapping("/update")
    public RestResult update(@RequestBody Way way){

        if(StringUtils.isBlank(way.getId()))
            throw new RuntimeException("id or value Can not be empty");

        // 防止恶意篡改固定数据
        way.setName(null);
        way.setGameId(null);

        WayExample example = new WayExample();
        WayExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(way.getId());
        AppUtils.support.getWayMapper().updateByExampleSelective(way,example);
        return RestResult.build();
    }

}
