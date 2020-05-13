package com.lx.emp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Vacation {
    private Integer vacationId;

    private String empNo;

    private String empName;

    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    private Date beginTime;

    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    private Date endTime;

    private String reason;

    private String approveName;

    private String approveNo;

    private Integer status;

    private String remark;
}