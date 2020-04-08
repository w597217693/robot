package com.bigcat.app.utils;

import java.util.Map;
import java.util.Set;

public class DefaultTemplateBuild implements TemplateBuild {

    @Override
    public String execute(String template, Map<String, String> map) {

        Set<String> keys = map.keySet();
        String out = "";
        for(String key:keys){
            String value = map.get(key);
            out = template.replace(key,value);
        }

        return out;
    }
}
