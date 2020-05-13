package com.lx.emp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Salery {
    private Integer id;

    private String empNo;

    private String empName;

    private BigDecimal workSalery;

    private BigDecimal allowance;

    private BigDecimal vacation;

    private BigDecimal reward;

    private BigDecimal absent;

    private BigDecimal total;

    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    private Date createtime;
}