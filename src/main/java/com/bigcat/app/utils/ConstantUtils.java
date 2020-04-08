package com.bigcat.app.utils;

import com.bigcat.app.anno.GateWay;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

public class ConstantUtils {

    public static final String CACHE_USER = "USER";


    public static GateWay gateWay = new GateWay();

    public static String LINE_FEED = "\r\n";
    //============数据字典常量=======================
    // 游戏类型
    public static final String GAME_TYPE = "a0da1e74-6107-11ea-8c24-0242ac110002";
    // 用户指令
    public static final String USER_WAY = "a0da1e74-6107-11ea-8c24-0242ac110002";
    public static final String PLAYER_TYPE = "f450f95c-6114-11ea-8c24-0242ac110002";
    public static final String HN5_GAME = "547247ba-6108-11ea-8c24-0242ac110002";


    //Settings id list
    // 上分成功提示
    public static final String UPPER_SCORE_SETTINGS = "a8770b5b-61e0-11ea-81de-0242ac110002";
    // 下分成功提示
    public static final String LOWER_SCORE_SETTINGS = "a8770b5b-61e0-11ea-81de-0242ac110002";
    // 查分成功提示
    public static final String QUERY_SCORE_SETTINGS = "68c3ea53-6446-11ea-81de-0242ac110002";
    // 下分余额不足提示
    public static final String BALANCE_SHORT_OF = "509668ed-7191-11ea-8753-0242ac110002";
    // 余额变动提醒
    public static final String BALANCE_CHANGE_TIPS = "09f4c30f-62ae-11ea-81de-0242ac110002";
    // 金额显示格式
    public static final String MONEY_FORMAT = "f10ad657-62a2-11ea-81de-0242ac110002";
    // 下注成功提示
    public static final String BETS_ORDER_SUCCESS_TIPS = "72365d0d-6746-11ea-8753-0242ac110002";
    // 下注失败，已经封盘提醒
    public static final String BETS_FAIL_STOP_BETS = "6142da84-69c5-11ea-8753-0242ac110002";
    // 下注失败，余分不足
    public static final String BETS_FAIL_BALANCE_SHORT_OF = "cacb7da8-6660-11ea-8753-0242ac110002";

    // 封盘核对
    public static final String STOP_BETS_CHECK = "39840780-65cd-11ea-8753-0242ac110002";
    // 账单格式设置
    public static final String BILL_FORMAT = "4c1d2717-67f7-11ea-8753-0242ac110002";
    // 中奖名单
    public static final String WIN_BILL = "360d33d1-7283-11ea-b944-0242ac110002";
    // 上分语音是否带分数
    public static final String IS_YU_YING = "fb3306fd-659e-11ea-8753-0242ac110002";

    // 查
    public static final String LOWER_SCORE_SUCCESS = "7234883b-62a1-11ea-81de-0242ac110002";
    // 到
    public static final String UPPER_SCORE_SUCCESS = "d93899b5-7014-11ea-8753-0242ac110002";
    // 没到
    public static final String UPPER_SCORE_FAIL = "1e59d0ea-62b3-11ea-81de-0242ac110002";

    // 上分消息返回至Q或群
    public static final String UPPER_MESSAGE_TO_GROUP = "4a3ea3f4-62b1-11ea-81de-0242ac110002";
    // 多少秒内请勿上下分
    public static final String REPEAT_UPPER_AND_LOWER = "0cac5d2b-6407-11ea-81de-0242ac110002";
    // 请勿上下分消息
    public static final String REPEAT_UPPER_AND_LOWER_TIPS = "ef402aa5-62b5-11ea-81de-0242ac110002";
    // 流水盈亏重置时间
    public static final String RESET_TIME = "267a29a3-74c5-11ea-8fbb-b42e99846016";
    // 查流水的模板
    public static final String QUERY_LIU_SHUI_TEMPLATE = "7DBEF877-6DE1-46FE-8729-F212A7012D04";
    // 取消订单无效模板
    public static final String CANCEL_ORDER_INVALID_TEMPLATE = "EA9FB818-2D17-4D33-BE04-ACFF2D805746";



    public enum PlayerSource{
        QQFriend("QQ好友",1),
        QQGroup("QQ群",2),
        QQPrivateChat("QQ群私聊",4);

        public String name;
        public Integer index;

        PlayerSource(String name, Integer index) {
            this.name = name;
            this.index = index;
        }

        public static String getName(Integer index){
            for(PlayerSource it : PlayerSource.values()){
                if(it.index.equals(index)){
                    return it.name;
                }
            }
            return null;
        }
    }

    public enum RunState{

        Stop("已封盘",-1),NotStop("未封盘",1);

        public String name;
        public Integer index;

        RunState(String name, Integer index) {
            this.name = name;
            this.index = index;
        }

        public static String getName(Integer index){
            for(RunState it : RunState.values()){
                if(it.index.equals(index)){
                    return it.name();
                }
            }
            return null;
        }
    }


    public enum BetsOrderStatus{

        Settled("已结算",1),NotSettled("未结算",2);

        public String name;
        public Integer index;

        BetsOrderStatus(String name, Integer index) {
            this.name = name;
            this.index = index;
        }

        public static String getName(Integer index){
            for(BetsOrderStatus it : BetsOrderStatus.values()){
                if(it.index.equals(index)){
                    return it.name();
                }
            }
            return null;
        }
    }

    public enum OpenRecordStatus{

        Open("已开奖",1),Close("未开奖",2),ManualOpen("手动开奖",3);

        public String name;
        public Integer index;

        OpenRecordStatus(String name, Integer index) {
            this.name = name;
            this.index = index;
        }

        public static String getName(Integer index){
            for(OpenRecordStatus it : OpenRecordStatus.values()){
                if(it.index.equals(index)){
                    return it.name();
                }
            }
            return null;
        }
    }

    public enum UserType{

        User("普通用户",1);

        public String name;
        public Integer index;

        UserType(String name, Integer index) {
            this.name = name;
            this.index = index;
        }

        public static String getName(Integer index){
            for(UserType it : UserType.values()){
                if(it.index.equals(index)){
                    return it.name;
                }
            }
            return null;
        }
    }


    public enum FinanceType{

        UpperScore("上分",1),LowerScore("下分",2),BetsOrder("投注",3),Win("中奖",4),Lose("未中奖",5),huishui("回水",6),fuli("福利",7);

        public String name;
        public Integer index;

        FinanceType(String name, Integer index) {
            this.name = name;
            this.index = index;
        }

        public static String getName(Integer index){
            for(FinanceType it : FinanceType.values()){
                if(it.index.equals(index)){
                    return it.name;
                }
            }
            return null;
        }
    }

    public enum FinanceCountType{

        add("加钱",2),subtract("扣钱",2);

        public String name;
        public Integer index;

        FinanceCountType(String name, Integer index) {
            this.name = name;
            this.index = index;
        }

        public static String getName(Integer index){
            for(FinanceCountType it : FinanceCountType.values()){
                if(it.index.equals(index)){
                    return it.name();
                }
            }
            return null;
        }
    }

    public enum FinanceStatus{

        NotExamine("未审核",1),Examine("已审核",2),ExamineFailed("审核不通过",-1),NotCalculation("不参与计算",3);

        public String name;
        public Integer index;

        FinanceStatus(String name, Integer index) {
            this.name = name;
            this.index = index;
        }

        public static String getName(Integer index){
            for(FinanceStatus it : FinanceStatus.values()){
                if(it.index.equals(index)){
                    return it.name();
                }
            }
            return null;
        }
    }

    public enum SettingsStatus{

        OpenText("开启文本",1),OpenImage("开启图片",2),Close("关闭",-1);

        public String name;
        public Integer index;

        SettingsStatus(String name, Integer index) {
            this.name = name;
            this.index = index;
        }

        public static String getName(Integer index){
            for(SettingsStatus it : SettingsStatus.values()){
                if(it.index.equals(index)){
                    return it.name();
                }
            }
            return null;
        }
    }


    public enum BalanceFormat{

        Integer("整数",1),decimal("保留两位小数",2);

        public String name;
        public Integer index;

        BalanceFormat(String name, Integer index) {
            this.name = name;
            this.index = index;
        }

        public static String getName(Integer index){
            for(BalanceFormat it : BalanceFormat.values()){
                if(it.index.equals(index)){
                    return it.name;
                }
            }
            return null;
        }
    }
    //======================================================
    public enum ErrorStatus{

        Void("无返回错误",400),
        Return("有返回错误",401);

        public String name;
        public Integer index;

        ErrorStatus(String name, Integer index) {
            this.name = name;
            this.index = index;
        }

        public static String getName(Integer index){
            for(ErrorStatus it : ErrorStatus.values()){
                if(it.index.equals(index)){
                    return it.name;
                }
            }
            return null;
        }
    }

}












































