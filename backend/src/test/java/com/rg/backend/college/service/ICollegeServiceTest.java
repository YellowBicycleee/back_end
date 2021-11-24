package com.rg.backend.college.service;

import com.rg.backend.college.entity.College;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ICollegeServiceTest {
    @Autowired
    ICollegeService collegeService;

    @Test
    public void getAllCollegeTest(){
        Map<String,Object> map = collegeService.getAllCollege(1);
        Long total = (Long) map.get("total");
        assertNotNull(total);
        List<College> colleges = (List<College>) map.get("colleges");
        assertNotNull(colleges);
    }

    @Test
    public void getCollegeCityTest(){
        Map<String,Object> map = collegeService.getCollegeByCity("北京",1);
        Long total = (Long) map.get("total");
        assertNotNull(total);
        List<College> colleges = (List<College>) map.get("colleges");
        assertEquals("北京",colleges.get(0).getCity());
    }
}