package com.bigcat.app.listener.handler.period;

import java.util.Date;

public interface HandlerUtils {

    Date openTime(long period);

    long period(int i);

    long nextPeriod(long period);

}
