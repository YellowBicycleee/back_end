package com.rg.backend.data.controller;

import com.alibaba.fastjson.JSON;
import com.rg.backend.college.entity.College;
import com.rg.backend.data.entity.ProvinceScoreData;
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

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProvinceScoreDataControllerTest {

    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @Before
    public void init(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getData() throws Exception {
        String response = mvc.perform(MockMvcRequestBuilders.get("/query/北京/理科"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(response);
        Map map = (Map) JSON.parse(response);
        String status = map.get("status").toString();
        List<ProvinceScoreData> provinceScoreDataList = (List<ProvinceScoreData>) map.get("data");
        assertEquals("200",status);
        assertNotNull(provinceScoreDataList);
    }

    @Test
    public void getData1() throws Exception {
        String response = mvc.perform(MockMvcRequestBuilders.get("/query/海南/文科"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(response);
        Map map = (Map) JSON.parse(response);
        String status = map.get("status").toString();
        List<ProvinceScoreData> provinceScoreDataList = (List<ProvinceScoreData>) map.get("data");
        assertEquals("200",status);
        assertNotNull(provinceScoreDataList);
    }

    @Test
    public void getData2() throws Exception {
        String response = mvc.perform(MockMvcRequestBuilders.get("/query/国外/文科"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(response);
        Map map = (Map) JSON.parse(response);
        String status = map.get("status").toString();
        List<ProvinceScoreData> provinceScoreDataList = (List<ProvinceScoreData>) map.get("data");
        assertEquals("500",status);
    }
}