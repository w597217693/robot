package com.bigcat.app.utils.enums;

import lombok.Getter;

public class LotteryTypeEnum {

    @Getter
    public enum LotteryStatus{

        CountDown("开奖倒计时",1),StopBets("封盘",2),OpenIng("正在开奖",3),Open("已开奖",4);

        private String name;
        private Integer index;

        LotteryStatus(String name,Integer index){
            this.name = name;
            this.index = index;
        }

        public static String getName(Integer index){
            for(LotteryStatus it : LotteryStatus.values()){
                if(it.index.equals(index)){
                    return it.name;
                }
            }
            return null;
        }
    }

    public enum LotterySystemStatus{

        Begin("开始下注",1),Cease("停止下注",2);

        private String name;
        private Integer index;

        LotterySystemStatus(String name,Integer index){
            this.name = name;
            this.index = index;
        }
        public static String getName(Integer index){
            for(LotterySystemStatus it : LotterySystemStatus.values()){
                if(it.index.equals(index)){
                    return it.name;
                }
            }
            return null;
        }
    }
}
