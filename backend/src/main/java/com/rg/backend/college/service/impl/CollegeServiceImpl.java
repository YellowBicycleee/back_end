package com.rg.backend.college.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rg.backend.college.entity.College;
import com.rg.backend.college.mapper.CollegeMapper;
import com.rg.backend.college.service.ICollegeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Byron Ji
 * @since 2021-11-24
 */
@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements ICollegeService {
    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public Map<String,Object> getAllCollege(Integer page) {
        IPage<College> iPage = new Page<>(page,20);
        IPage collegePage = collegeMapper.selectPage(iPage,null);
        Map<String,Object> map=new HashMap<String,Object>();
        Long total = collegePage.getTotal();
        List<College> colleges =collegePage.getRecords();
        map.put("total",total);
        map.put("colleges",colleges);
        return map;
    }

    @Override
    public Map<String,Object> getCollegeByCity(String city, Integer page) {
        IPage<College> iPage = new Page<>(page,20);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("city", city);
        IPage collegePage = collegeMapper.selectPage(iPage,wrapper);
        Long total = collegePage.getTotal();
        List<College> colleges =collegePage.getRecords();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",total);
        map.put("colleges",colleges);
        return map;
    }
}
