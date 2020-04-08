package com.bigcat.app.utils.enums;

import lombok.Getter;

public class PlayerEnum {

    @Getter
    public enum PlayerType{
        Player("玩家",1),PlayerRobot("人工机器人",2),SystemRobot("系统机器人",3),Sale("推手",4);
        private String name;
        private Integer index;

        PlayerType(String name,Integer index){
            this.name = name;
            this.index = index;
        }
        public static String getName(Integer index){
            for(PlayerType it : PlayerType.values()){
                if(it.index.equals(index)){
                    return it.name;
                }
            }
            return null;
        }
    }
}
