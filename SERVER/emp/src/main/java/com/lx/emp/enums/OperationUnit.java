package com.lx.emp.enums;

public enum OperationUnit {
    /**
     * 被操作的单元
     */
    UNKNOWN("unknown"),
    DEPARTMENT("department"),
    EMPLOYEE("employee"),
    SALERY("salery"),
    VACATION("vacation"),
    ROLE("role"),
    ATTEND("attend"),
    PERMISSION("permission");

    private String value;

    OperationUnit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
