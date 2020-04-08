package com.bigcat.app.controller;

import com.bigcat.app.pojo.DictInfo;
import com.bigcat.app.pojo.DictInfoExample;
import com.bigcat.app.pojo.DictType;
import com.bigcat.app.pojo.DictTypeExample;
import com.bigcat.app.utils.AppUtils;
import com.bigcat.app.utils.RestResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dict")
public class DictController {

    @GetMapping("/info/all")
    public RestResult findByInfo(@RequestParam(defaultValue = "") String dictTypeId){
        DictInfoExample example = new DictInfoExample();
        DictInfoExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(dictTypeId))
            criteria.andDictTypeIdEqualTo(dictTypeId);

        List dictInfos = AppUtils.support.getDictInfoMapper().selectByExample(example);
        return RestResult.build().array()
                .add(dictInfos);
    }

    @GetMapping("/type/all")
    public RestResult findByType(@RequestParam(defaultValue = "") String dictTypeId){
        DictTypeExample example = new DictTypeExample();
        DictTypeExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(dictTypeId))
            criteria.andIdEqualTo(dictTypeId);

        List<DictType> dictTypes = AppUtils.support.getDictTypeMapper().selectByExample(example);
        return RestResult.build().array()
                .add(dictTypes);

    }


    @GetMapping("/playerIn")
    public RestResult getPerlayerIn(){


        return null;
    }
}
