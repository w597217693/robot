package com.bigcat.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration //配置类
//@EnableSwagger2 //启用Swagger2
public class Swagger2Config {
    @Bean
    public Docket apiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)//创建Swagger2类型的文档
                .apiInfo(apiInfo());//apiInfo方法返回配置的接口信息
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("用户中心微服务前台网站API")//接口标题
                .description("此文档描述了用户中心前台App的基本API接口")//接口描述
                .version("1.0")//接口版本
                .contact(new Contact("Jack", "http://www.jikedaquan.com", "jikedaquan@163.com"))//联系方式：名字、网址、邮箱
                .build();
    }
}
