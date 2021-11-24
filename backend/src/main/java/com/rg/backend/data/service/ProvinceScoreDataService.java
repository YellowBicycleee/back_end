package com.rg.backend.data.service;

import com.rg.backend.data.dao.ProvinceScoreDataDao;
import com.rg.backend.data.entity.ProvinceScoreData;

import java.sql.SQLException;
import java.util.List;

public class ProvinceScoreDataService {
    private ProvinceScoreDataDao provinceScoreDataDao=new ProvinceScoreDataDao();

    public List<ProvinceScoreData> queryByProvinceAndType(String province,String type,int fromIndex) throws SQLException {
        return provinceScoreDataDao.queryByProvinceAndType(province,type,fromIndex);
    }
}
