package com.bigcat.app.utils;

import java.util.Map;

public interface TemplateBuild {
    String execute(String template , Map<String,String> map);
}
