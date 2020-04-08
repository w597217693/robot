package com.bigcat.app.listener.handler;

import com.alibaba.fastjson.JSONArray;
import com.bigcat.app.dto.InterfaceResult;
import com.bigcat.app.listener.handler.period.HandlerUtils;
import com.bigcat.app.pojo.OpenRecord;
import com.bigcat.app.utils.AppUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service("HN5Handler")
public class HN5Handler extends LotteryHandler {

    @Override
    protected String gameId() {
        return "547247ba-6108-11ea-8c24-0242ac110002";
    }

    @Override
    protected String handlerName() {
        return "HN5Handler";
    }

    @Override
    protected long stopBetsSecond() {
        return 30;
    }

    @Override
    protected HandlerUtils utils() {
        return AppUtils.support.getHandlerMap().get("HN5Utils");
    }

    @Override
    protected String getPath() {
        return "/SSC/";
    }

    @JmsListener(destination = "OpenData2")
    public void receiver(String msg){

        JSONArray objects = JSONArray.parseArray(msg);
        Long period = objects.getLong(0);
        InterfaceResult interfaceResult = objects.getObject(1,InterfaceResult.class);

        OpenRecord record = new OpenRecord();
        record.setGameid(gameId());
        record.setId(UUID.randomUUID().toString());
        record.setResult(interfaceResult.getNumber());
        record.setPeriod(period);
        record.setOpenTime(interfaceResult.getDateline());
        this.service(record);
    }
}
