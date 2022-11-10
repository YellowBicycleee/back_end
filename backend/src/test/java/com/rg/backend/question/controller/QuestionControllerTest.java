package com.rg.backend.question.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @Before
    public void init(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    public void questionTest() throws Exception {
//        String response = mvc.perform(MockMvcRequestBuilders.get("/qa/国科大/").characterEncoding(StandardCharsets.UTF_8))
//                .andReturn().getResponse().getContentAsString();
//        System.out.println(response);
//        JSONObject map = (JSONObject) JSON.parse(response);
//        String answer = map.get("answer").toString();
//        System.out.println(answer);
//        assertNotNull(answer);
    }
}
