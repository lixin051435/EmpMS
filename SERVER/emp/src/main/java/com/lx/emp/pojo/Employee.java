package com.lx.emp.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Employee {
    private Integer empId;

    private String empNo;

    private String empName;

    private String empPassword;

    private String empIdcard;

    private String empSalerycard;

    private String empGender;

    private String empPhone;

    private String empEmail;

    private Integer empStatus;

    /**
     * 员工角色编号
     */
    private String empType;

    /**
     * 部门编号
     */
    private String deptId;

    /**
     * 部门名称
     */
    private String deptName;


    private List<Permission> permissions = new ArrayList<>();


}