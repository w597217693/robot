package com.bigcat.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-dev.yml")
@WebAppConfiguration
public class BaseServiceTest {

    @Autowired
    protected WebApplicationContext wac;
    protected MockMvc mvc;
    protected MockHttpSession session;

    @Before
    public void before()throws Exception{
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    protected String post(String uri,String json) throws Exception {

        System.out.println("请求url:\n"+uri+"\n请求json数据：\n");
        this.print(json);

        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                //.andDo(MockMvcResultHandlers.print())
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        String response = mvcResult.getResponse().getContentAsString();
        this.print(response);
        return response;
    }

    protected String get(String uri) throws Exception {

        System.out.println("请求url:\n"+uri);

        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                //.andDo(MockMvcResultHandlers.print())
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        String response = mvcResult.getResponse().getContentAsString();
        this.print(response);
        return response;
    }

    protected  void print(String json){
        Object params = JSONObject.parse(json);
        String jsonString = JSON.toJSONString(params, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
        System.out.println(jsonString);
    }

}
