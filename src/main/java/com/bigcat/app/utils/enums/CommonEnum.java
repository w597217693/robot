package com.bigcat.app.utils.enums;

import lombok.Getter;

public class CommonEnum {


    @Getter
    public enum IsDel{
        Delete("删除",1),UnDelete("未删除",2);
        private String name;
        private Integer index;

        IsDel(String name,Integer index){
            this.name = name;
            this.index = index;
        }
        public static String getName(Integer index){
            for(IsDel it : IsDel.values()){
                if(it.index.equals(index)){
                    return it.name;
                }
            }
            return null;
        }
    }
    @Getter
    public enum PayInfoType{
        AliPay("支付宝",1),WXPay("微信",2),Bank("银行账户",3);
        private String name;
        private Integer index;

        PayInfoType(String name,Integer index){
            this.name = name;
            this.index = index;
        }
        public static String getName(Integer index){
            for(PayInfoType it : PayInfoType.values()){
                if(it.index.equals(index)){
                    return it.name;
                }
            }
            return null;
        }
    }

    @Getter
    public enum GlobalGameStatus{
        StopBets("封盘中",1),OpenResult("开奖中",2),CountDown("倒计时",3);
        private String name;
        private Integer index;

        GlobalGameStatus(String name,Integer index){
            this.name = name;
            this.index = index;
        }
        public static String getName(Integer index){
            for(GlobalGameStatus it : GlobalGameStatus.values()){
                if(it.index.equals(index)){
                    return it.name;
                }
            }
            return null;
        }
    }

    @Getter
    public enum IsStartGame{
        GameStart("游戏启动",1),GameStop("游戏关闭",2);
        private String name;
        private Integer index;

        IsStartGame(String name,Integer index){
            this.name = name;
            this.index = index;
        }
        public static String getName(Integer index){
            for(IsStartGame it : IsStartGame.values()){
                if(it.index.equals(index)){
                    return it.name;
                }
            }
            return null;
        }
    }

    @Getter
    public enum LotteryType{
        cqssc("重庆时时彩",1),hnk3("河内快三",2),azxy5("澳洲幸运5",3);

        private String name;
        private Integer index;

        LotteryType(String name,Integer inxdex){
            this.index = inxdex;
            this.name = name;
        }

        public static String getName(Integer index){
            for(LotteryType item:LotteryType.values()){
                if(item.index.equals(index)){
                    return item.getName();
                }
            }
            return null;
        }
    }

}
