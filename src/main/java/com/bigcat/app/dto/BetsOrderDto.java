package com.bigcat.app.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 投注的实体对象
 */
@Data
public class BetsOrderDto {
    private String playerIn;
    private List<BetsOrderItemDto> orders;
}
