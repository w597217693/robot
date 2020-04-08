package com.bigcat.app.service.impl;

import com.bigcat.app.dao.PlayerMapper;
import com.bigcat.app.pojo.Player;
import com.bigcat.app.pojo.PlayerExample;
import com.bigcat.app.utils.AppUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService{


    public Player findByAccount(String account){

        PlayerExample example = new PlayerExample();
        example.createCriteria().andAccountEqualTo(account);
        List<Player> players = getMapper().selectByExample(example);
        if(players == null || players.size() == 0)
            return null;

        return players.get(0);
    }


    public PlayerMapper getMapper(){
        return AppUtils.support.getPlayerMapper();
    }

}
