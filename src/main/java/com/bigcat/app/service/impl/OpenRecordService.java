package com.bigcat.app.service.impl;

import com.bigcat.app.dao.OpenRecordMapper;
import com.bigcat.app.dto.InterfaceResult;
import com.bigcat.app.pojo.OpenRecord;
import com.bigcat.app.pojo.OpenRecordExample;
import com.bigcat.app.utils.AppUtils;
import com.bigcat.app.utils.ConstantUtils;
import com.bigcat.app.utils.PeriodUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OpenRecordService {
    public OpenRecordMapper getMapper(){
        return AppUtils.support.getOpenRecordMapper();
    }
}








































