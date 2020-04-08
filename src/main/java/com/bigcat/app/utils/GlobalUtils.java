package com.bigcat.app.utils;

import com.bigcat.app.pojo.Player;
import com.bigcat.app.pojo.Settings;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

@Component
public class GlobalUtils {

    public static SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日mm分ss秒");

    public Player validPlayer(String id){
        if(StringUtils.isBlank(id))
            throw new RuntimeException("id is null");
        Player player = AppUtils.support.getPlayerMapper().selectByPrimaryKey(id);
        if(player == null)
            throw new RuntimeException("player object is null");

        return player;
    }

    public String formatBalance(BigDecimal balance){
        Settings settings = AppUtils.support.getSettingsMapper().selectByPrimaryKey("7234883b-62a1-11ea-81de-0242ac110002");

        if(settings.getStatus().equals(ConstantUtils.SettingsStatus.OpenText.index)){
            Integer value = Integer.parseInt(settings.getTemplateText());
            if(value.equals(ConstantUtils.BalanceFormat.Integer.index))
                balance = balance.setScale(0, BigDecimal.ROUND_FLOOR);
            else
                balance = balance.setScale(2, BigDecimal.ROUND_FLOOR);
        }

        return balance+"";
    }

    public String formatNickname(String nickname){
        Settings settings = AppUtils.getSettings("cb73ab80-6902-11ea-8753-0242ac110002");
        if(settings.getStatus().equals(ConstantUtils.SettingsStatus.OpenText.index)){
            if(nickname.length() > 2){
                return nickname.substring(0,2);
            }
        }
        return nickname;
    }

    /**
     * 计算开奖结果的合值
     * @param result
     * @return
     */
    public Integer resultSum(String result){
        String[] nums = result.split(",");
        int sum = 0;
        for(String it : nums){
            int num = Integer.parseInt(it);
            sum+=num;
        }
        return sum;
    }

    public Player getPlayer(String playerId){
        return AppUtils.support.getPlayerMapper().selectByPrimaryKey(playerId);
    }


}
