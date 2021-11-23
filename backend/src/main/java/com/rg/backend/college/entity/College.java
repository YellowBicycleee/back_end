package com.rg.backend.college.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Byron Ji
 * @since 2021-11-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class College implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String icon;

    private String city;

    private String department;

    private String type;

    private String levels;

    private String charact;

    private String url;


}
