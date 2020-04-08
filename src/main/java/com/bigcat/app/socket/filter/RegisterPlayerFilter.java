package com.bigcat.app.socket.filter;

import com.alibaba.fastjson.JSONObject;
import com.bigcat.app.dao.PlayerMapper;
import com.bigcat.app.pojo.Player;
import com.bigcat.app.service.impl.PlayerService;
import com.bigcat.app.utils.AppUtils;
import com.bigcat.app.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * 如果有用户发起指令，就判断数据库中是否有该用户的数据，如果没有就进行注册
 */
@Service
public class RegisterPlayerFilter  {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerMapper playerMapper;

    public Player doFilter(String account , String nickname , Integer source) {

        Player player = playerService.findByAccount(account);

        if(player == null){
            player = new Player();
            player.setId(UUID.randomUUID().toString());
            player.setNickname(nickname);
            player.setType(ConstantUtils.UserType.User.index);
            player.setStatus(null);
            player.setCreateTime(new Date());
            player.setAccount(account);
            player.setSource(source);
            player.setBalance(new BigDecimal(0));
            AppUtils.support.getPlayerMapper().insert(player);
        }else{
            if(!player.getNickname().equals(nickname)){
                player.setNickname(nickname);
            }

            Integer s = player.getSource();
            if(s == null || !s.equals(source)){
                player.setSource(source);
            }

            playerMapper.updateByPrimaryKeySelective(player);
        }

        return player;
    }
}







































