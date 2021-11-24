package com.rg.backend.college.service;

import com.rg.backend.college.entity.College;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Byron Ji
 * @since 2021-11-24
 */
public interface ICollegeService extends IService<College> {
    Map<String,Object> getAllCollege(Integer page);
    Map<String,Object> getCollegeByCity(String city,Integer page);

}
