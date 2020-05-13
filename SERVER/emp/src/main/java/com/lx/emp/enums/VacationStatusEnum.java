package com.lx.emp.enums;

public enum VacationStatusEnum {
    RECALL(-1,"已撤回"),
    COMMITED(0,"已提交"),
    SUCCESS(1,"成功"),
    REJECTED(2,"拒绝");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    VacationStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
