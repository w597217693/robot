package com.bigcat.app.controller;

import com.alibaba.fastjson.JSONArray;
import com.bigcat.app.controller.req.UpdateSettings;
import com.bigcat.app.pojo.*;
import com.bigcat.app.utils.AppUtils;
import com.bigcat.app.utils.RestResult;
import com.bigcat.app.utils.TemplateBuild;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/settings")
public class SettingsController {


    @GetMapping("/all")
    public RestResult findSettingsAll(@RequestParam(defaultValue = "") String settingsId){

        SettingsExample example = new SettingsExample();
        SettingsExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(settingsId))
            criteria.andIdEqualTo(settingsId);
        List settings = AppUtils.support.getSettingsMapper().selectByExample(example);
        return RestResult.build().array()
                .add(settings);
    }

    @PostMapping("/update")
    public RestResult updateSettings(@RequestBody UpdateSettings obj){

        Settings settings = AppUtils.support.getSettingsMapper().selectByPrimaryKey(obj.getSettingsId());

        if(settings == null)
            throw new RuntimeException("id is null");

        if(obj.getStatus() != null)
            settings.setStatus(obj.getStatus());
        if(StringUtils.isNotBlank(obj.getTemplateText()))
            settings.setTemplateText(obj.getTemplateText());
        if(StringUtils.isNotBlank(obj.getTemplateImage()))
            settings.setTemplateImage(obj.getTemplateImage());

        AppUtils.support.getSettingsMapper().updateByPrimaryKeySelective(settings);
        return RestResult.build().array()
                .add(settings);
    }

    /**
     *  图片绑定模板
     * @return
     */
    @GetMapping("/bind-image")
    public RestResult bindImage(String settingsId,String imageName){

        Settings settings = AppUtils.support.getSettingsMapper().selectByPrimaryKey(settingsId);
        if(settings == null)
            throw new RuntimeException("Sorry settings Id is not null");

        settings.setTemplateImage(imageName);
        AppUtils.support.getSettingsMapper().updateByPrimaryKeySelective(settings);

        return RestResult.build();
    }

}
