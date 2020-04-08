package com.bigcat.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static SimpleDateFormat yMdHms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat yMd = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");


    public static Date toYMdHms(String shi , String fen , String miao){
        try {
            return yMdHms.parse(getNowYmd()+" "+shi + ":" + fen + ":" + miao);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getNowYmd(){
        return yMd.format(new Date());
    }
    public static Date now(){
        return new Date();
    }


    public static void main(String[] args) {
        Date date = DateUtils.toYMdHms("00", "00", "00");
        System.out.println(date);
    }

}
