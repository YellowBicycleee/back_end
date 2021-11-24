package com.rg.backend.college.service;

import com.rg.backend.college.entity.College;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ICollegeServiceTest {
    @Autowired
    ICollegeService collegeService;

    @Test
    public void getAllCollegeTest(){
        List<College> colleges = collegeService.getAllCollege(1);
        assertNotNull(colleges);
    }

    @Test
    public void getCollegeCityTest(){
        List<College> colleges = collegeService.getCollegeByCity("北京",1);
        assertNotNull(colleges);
        assertEquals("北京",colleges.get(0).getCity());
    }
}