package com.bigcat.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PeriodUtils {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat dateFormat4 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");


    public static long getHN3NextPeriod(long nextNum){
//        try{
//            Date current = new Date(new Date().getTime() + (nextNum * (60000 * 5)));
//            String prefix = dateFormat.format(current);
//            Date dayToStart = dateFormat2.parse(prefix + " 00:00:00");
//            long runOffTime = dayToStart.getTime() - current.getTime();
//            long suffix = runOffTime / (60000 * 5);
//            return Long.parseLong((prefix + "" + suffix).replace("-",""));
//        }catch (ParseException e){
//            throw new RuntimeException("下期期号解析错误");
//        }
        return 0;
    }

    public static Date getHN3TimeByPeriod(long period ,long nextNum) {
        try{
//            String prefix = (period + "").substring(0,8);
//            String suffix = (period + "").substring(8);
//            long runOffTime = (Long.parseLong(suffix) * (60000 * 5)) + (nextNum * (60000 * 5));
//            Date dayToStart = dateFormat4.parse(prefix + " 00:00:00");
//            return new Date(dayToStart.getTime() + runOffTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
