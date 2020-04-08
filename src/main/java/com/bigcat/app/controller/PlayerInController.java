package com.bigcat.app.controller;

import com.bigcat.app.dao.PlayerInMapper;
import com.bigcat.app.pojo.PlayerIn;
import com.bigcat.app.pojo.PlayerInExample;
import com.bigcat.app.service.impl.PlayerInService;
import com.bigcat.app.utils.AppUtils;
import com.bigcat.app.utils.RestResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playerIn")
public class PlayerInController {

    @Autowired
    private PlayerInService playerInService;

    @GetMapping
    public RestResult findAll(){
        PlayerInExample example = new PlayerInExample();
        List playerIns = AppUtils.support.getPlayerInMapper().selectByExample(example);
        return RestResult.build().array().add(playerIns);
    }

    @GetMapping("/update-value")
    public RestResult update(@RequestParam(defaultValue = "")String id , @RequestParam(defaultValue = "") String value){
        playerInService.update(id,value);
        return RestResult.build();
    }

}
