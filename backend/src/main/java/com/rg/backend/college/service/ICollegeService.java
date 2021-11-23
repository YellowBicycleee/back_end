package com.rg.backend.college.service;

import com.rg.backend.college.entity.College;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Byron Ji
 * @since 2021-11-24
 */
public interface ICollegeService extends IService<College> {
    List<College> getAllCollege();
    List<College> getCollegeByCity(String city);

}
