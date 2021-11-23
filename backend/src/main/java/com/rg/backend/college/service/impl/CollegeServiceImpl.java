package com.rg.backend.college.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rg.backend.college.entity.College;
import com.rg.backend.college.mapper.CollegeMapper;
import com.rg.backend.college.service.ICollegeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<College> getAllCollege() {
        return collegeMapper.selectList(null);
    }

    @Override
    public List<College> getCollegeByCity(String city) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("city", city);
        return collegeMapper.selectList(wrapper);
    }
}
