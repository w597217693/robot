package com.bigcat.app.utils.enums;

import lombok.Getter;

public class FinanceEnum {

    @Getter
    public enum FinanceStatus{

        Audited("通过审核",1),UnAudited("未审核",2),AuditedFail("审核失败",3);

        private String name;
        private Integer index;

        FinanceStatus(String name,Integer index){
            this.name = name;
            this.index = index;
        }
        public static String getName(Integer index){
            for(FinanceStatus it : FinanceStatus.values()){
                if(it.index.equals(index)){
                    return it.name;
                }
            }
            return null;
        }
    }

    @Getter
    public enum FinanceType{

        UpperScore("上分",1),LowerScore("下分",2),Bets("投注",3);

        private String name;
        private Integer index;

        FinanceType(String name,Integer index){
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
    }@Getter
    public enum FinanceCountType{

        add("相加",1),Subtract("减去",2);

        private String name;
        private Integer index;

        FinanceCountType(String name,Integer index){
            this.name = name;
            this.index = index;
        }
        public static String getName(Integer index){
            for(FinanceCountType it : FinanceCountType.values()){
                if(it.index.equals(index)){
                    return it.name;
                }
            }
            return null;
        }
    }


}
