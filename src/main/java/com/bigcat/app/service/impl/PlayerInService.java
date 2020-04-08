package com.bigcat.app.service.impl;

import com.bigcat.app.dao.PlayerInMapper;
import com.bigcat.app.pojo.PlayerIn;
import com.bigcat.app.pojo.PlayerInExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerInService {

    @Autowired
    private PlayerInMapper playerInMapper;

    public void update(String id , String value){

        PlayerIn playerIn = new PlayerIn();
        playerIn.setValue(value);

        PlayerInExample example = new PlayerInExample();
        PlayerInExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);

        playerInMapper.updateByExampleSelective(playerIn,example);
    }

}
