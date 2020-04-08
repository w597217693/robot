package com.bigcat.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.dialect.SpringStandardDialect;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.StringTemplateResolver;

@Configuration
public class WebConfig {

    @Bean
    public SpringTemplateEngine stringTemplateEngine(){
        SpringTemplateEngine engine = new SpringTemplateEngine();

        // 内置方言
        IDialect dialect = new SpringStandardDialect();
        engine.setDialect(dialect);

        // 字符串解析器
        StringTemplateResolver resolver = new StringTemplateResolver();

        // 使用缓存
        resolver.setCacheable(true);
        resolver.setTemplateMode(TemplateMode.HTML);

        engine.setTemplateResolver(resolver);

        return engine;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}