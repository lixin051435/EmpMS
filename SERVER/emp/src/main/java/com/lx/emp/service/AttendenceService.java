package com.lx.emp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lx.emp.annotation.OperationLogDetail;
import com.lx.emp.dao.AttendenceMapper;
import com.lx.emp.dao.EmployeeMapper;
import com.lx.emp.enums.OperationType;
import com.lx.emp.enums.OperationUnit;
import com.lx.emp.pojo.Attendence;
import com.lx.emp.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AttendenceService {
    
    @Autowired
    private AttendenceMapper attendenceMapper;

    @OperationLogDetail(detail = "增加考勤",level = 3,operationUnit = OperationUnit.ATTEND,operationType = OperationType.INSERT)
    public boolean save(Attendence employee){
        return attendenceMapper.insertSelective(employee) > 0;
    }

    @OperationLogDetail(detail = "删除考勤",level = 4,operationUnit = OperationUnit.ATTEND,operationType = OperationType.DELETE)
    public boolean remove(Integer id){
        return attendenceMapper.deleteByPrimaryKey(id) > 0;
    }

    @OperationLogDetail(detail = "修改考勤",level = 2,operationUnit = OperationUnit.ATTEND,operationType = OperationType.UPDATE)
    public boolean update(Attendence employee){
        return attendenceMapper.updateByPrimaryKeySelective(employee) > 0;
    }

    @OperationLogDetail(detail = "根据ID获取考勤",level = 1,operationUnit = OperationUnit.ATTEND,operationType = OperationType.SELECT)
    public Attendence findById(Integer id){
        return attendenceMapper.selectByPrimaryKey(id);
    }

    @OperationLogDetail(detail = "获取考勤列表",level = 1,operationUnit = OperationUnit.ATTEND,operationType = OperationType.SELECT)
    public PageInfo<Attendence> findAll(int page, int size, String name, String no){
        PageHelper.startPage(page,size);
        List<Attendence> employees = attendenceMapper.findAll(name,no);
        PageInfo<Attendence> pageInfo = new PageInfo<>(employees);
        pageInfo.setList(employees);
        return pageInfo;
    }

    @OperationLogDetail(detail = "根据下班打卡时间获取考勤",level = 1,operationUnit = OperationUnit.ATTEND,operationType = OperationType.SELECT)
    public Attendence getByEmpNoAndBeginTime(String no,String begin,String end){
        return attendenceMapper.getByEmpNoAndBeginTime(no,begin,end);
    }
    @OperationLogDetail(detail = "根据上班打卡获取考勤列表",level = 1,operationUnit = OperationUnit.ATTEND,operationType = OperationType.SELECT)
    public Attendence getByEmpNoAndEndTime(String no,String begin,String end){
        return attendenceMapper.getByEmpNoAndEndTime(no,begin,end);
    }
}
