package com.bigcat.app.utils.enums;

import lombok.Getter;

public class OrderEnum {

    @Getter
    public enum OrderStatus{

        Settlement("已结算",1),Unsettled("未结算",2),RevokeOrder("撤销订单",3);
        private String name;
        private Integer index;

        OrderStatus(String name,Integer index){
            this.name = name;
            this.index = index;
        }
        public static String getName(Integer index){
            for(OrderStatus it : OrderStatus.values()){
                if(it.index.equals(index)){
                    return it.name;
                }
            }
            return null;
        }
    }


}
