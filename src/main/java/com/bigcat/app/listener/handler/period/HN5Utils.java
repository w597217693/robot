package com.bigcat.app.listener.handler.period;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service("HN5Utils")
public class HN5Utils implements HandlerUtils {

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat dateFormat4 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

    @Override
    public Date openTime(long period) {
        return openTime(period,0);
    }

    private Date openTime(long period , long nextNum) {
        try{
            String prefix = (period + "").substring(0,8);
            String suffix = (period + "").substring(8);
            long runOffTime = (Long.parseLong(suffix) * (60000 * 5)) + (nextNum * (60000 * 5));
            Date dayToStart = dateFormat4.parse(prefix + " 00:00:00");
            return new Date(dayToStart.getTime() + runOffTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private long period(Date date){
        try{
            String prefix = dateFormat.format(date);
            Date dayToStart = dateFormat2.parse(prefix + " 00:00:00");
            long runOffTime = dayToStart.getTime() - date.getTime();
            long suffix = runOffTime / (60000 * 5);
            return Long.parseLong((prefix + "" + suffix).replace("-",""));
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public long period(int i) {
        return period(new Date(new Date().getTime() + (i * (60000 * 5))));
    }

    @Override
    public long nextPeriod(long period) {
        return period(openTime(period,1));
    }
}
