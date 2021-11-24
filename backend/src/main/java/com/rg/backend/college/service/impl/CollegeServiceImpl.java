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
    public List<College> getAllCollege(Integer page) {
        IPage<College> iPage = new Page<>(page,20);
        return collegeMapper.selectPage(iPage,null).getRecords();
    }

    @Override
    public List<College> getCollegeByCity(String city,Integer page) {
        IPage<College> iPage = new Page<>(page,20);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("city", city);
        return collegeMapper.selectPage(iPage,wrapper).getRecords();
    }
}
