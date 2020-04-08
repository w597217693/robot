package com.bigcat.app.utils;

import com.bigcat.app.dao.*;
import com.bigcat.app.handler.SSCCalculation;
import com.bigcat.app.listener.handler.LotteryHandler;
import com.bigcat.app.listener.handler.period.HandlerUtils;
import com.bigcat.app.service.impl.*;
import com.bigcat.app.socket.filter.RegisterPlayerFilter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.Map;

@Component
@Data
public class GlobalBeanSupport {

    @Autowired
    private SpringTemplateEngine templateEngine;

//    @Autowired
//    private Map<String, WebSocketFilter> filter;

    @Autowired
    private Cache cache;

    @Autowired
    private PlayerMapper playerMapper;
    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerInMapper playerInMapper;

    @Autowired
    private ImagesMapper imagesMapper;
    @Autowired
    private ImageService imageService;

    @Autowired
    private GlobalUtils utils;

    @Autowired
    private FinanceMapper financeMapper;
    @Autowired
    private FinanceService financeService;

    @Autowired
    private DictInfoMapper dictInfoMapper;

    @Autowired
    private SettingsMapper settingsMapper;

    @Autowired
    private DictTypeMapper dictTypeMapper;
    @Autowired
    private BetsOrderMapper betsOrderMapper;
    @Autowired
    private OpenRecordMapper openRecordMapper;
    @Autowired
    private BetsOrderService betsOrderService;
    @Autowired
    private WayMapper wayMapper;
    @Autowired
    private WayService wayService;
    @Autowired
    private OpenRecordService openRecordService;
    @Autowired
    Map<String, HandlerUtils> handlerMap;
    @Autowired
    private Map<String, LotteryHandler> lotteryHandlerMap;

    @Autowired
    private TemplateService templateService;

    @Autowired
    private RegisterPlayerFilter registerFilter;
    @Autowired
    private SSCCalculation calculation;


}
