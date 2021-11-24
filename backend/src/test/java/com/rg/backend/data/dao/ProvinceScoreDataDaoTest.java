package com.rg.backend.data.dao;

import com.rg.backend.data.dao.ProvinceScoreDataDao;
import com.rg.backend.data.entity.ProvinceScoreData;
import com.rg.backend.util.DBUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ProvinceScoreDataDaoTest {
    public Connection conn;
    ProvinceScoreDataDao dao;

    //连接测试
    @Test
    public void testConnection(){
        conn = DBUtil.getConnection();
        assertNotNull(conn);
    }
    //初始化dao
    @Before
    public void init(){
        dao = new ProvinceScoreDataDao();
    }
    /**
     * 对于数据表查询的一些测试
     */
    @Test
    public void testGetTable() throws SQLException {
        Map map = dao.queryByProvinceAndType("海南","文科",1);
        int total = (int) map.get("total");
        assertNotNull(total);
        List<ProvinceScoreData> list = (List<ProvinceScoreData>) map.get("provinceScoreDataList");
        assertNotNull(list);
    }
    @Test
    public void testGetTable2() throws SQLException{
        Map map = dao.queryByProvinceAndType("湖北","理科",10);
        int total = (int) map.get("total");
        assertNotNull(total);
        List<ProvinceScoreData> list = (List<ProvinceScoreData>) map.get("provinceScoreDataList");
        assertNotNull(list);
    }
    @Test(expected = SQLException.class)
    public void testGetTable3() throws SQLException{
        dao.queryByProvinceAndType("武汉","理科",0);
    }
    @Test(expected = SQLException.class)
    public void testGetTable4() throws SQLException{
        dao.queryByProvinceAndType("湖北","文理科",0);
    }
    @Test(expected = SQLException.class)
    public void testGetTable5() throws SQLException{
        dao.queryByProvinceAndType("湖北","理科",0);
    }
}