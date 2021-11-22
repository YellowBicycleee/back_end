package com.rg.backend.data.entity;

import lombok.Data;

import java.sql.Driver;

@Data
public class ProvinceScoreData {
    private String province;
    private String city;
    private String F985;
    private String F211;
    private String doubleFirstClass;
    private String school;
    private int avg2016;
    private int rank2016;
    private int avg2017;
    private int rank2017;
    private int avg2018;
    private int rank2018;
    private int avg2019;
    private int rank2019;
    private int avg2020;
    private int rank2020;


}
