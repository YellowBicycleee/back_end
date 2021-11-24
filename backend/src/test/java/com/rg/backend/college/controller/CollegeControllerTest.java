package com.rg.backend.college.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rg.backend.college.entity.College;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.alibaba.fastjson.JSON;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollegeControllerTest {

    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @Before
    public void init(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    public void queryAllCollege() throws Exception {
        String response = mvc.perform(MockMvcRequestBuilders.get("/college/all/1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(response);
        JSONObject map = (JSONObject) JSON.parse(response);
        String status = map.get("status").toString();
        JSONArray colleges = map.getJSONArray("data");
        assertEquals("200",status);
        assertNotNull(colleges);
    }

    @Test
    public void queryCollegeByCity() throws Exception {
        String response = mvc.perform(MockMvcRequestBuilders.get("/college/北京/1").characterEncoding(StandardCharsets.UTF_8))
                .andReturn().getResponse().getContentAsString();
        System.out.println(response);
        JSONObject map = (JSONObject) JSON.parse(response);
        String status = map.get("status").toString();
        assertEquals("200",status);
        JSONArray colleges = map.getJSONArray("data");
        JSONObject college = colleges.getJSONObject(0);
        String city = college.getString("city");
        assertNotNull(colleges);
        assertEquals("北京",city);
    }



}