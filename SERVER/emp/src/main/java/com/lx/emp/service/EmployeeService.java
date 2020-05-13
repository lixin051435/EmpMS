package com.lx.emp.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lx.emp.annotation.OperationLogDetail;
import com.lx.emp.dao.EmployeeMapper;
import com.lx.emp.enums.OperationType;
import com.lx.emp.enums.OperationUnit;
import com.lx.emp.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeMapper employeeMapper;

    @OperationLogDetail(detail = "修改密码",level = 2,operationUnit = OperationUnit.EMPLOYEE,operationType = OperationType.UPDATE)
    public boolean changePassword(String no,String password){
        return employeeMapper.changePassword(no,password) > 1;
    }

    @OperationLogDetail(detail = "增加员工",level = 3,operationUnit = OperationUnit.EMPLOYEE,operationType = OperationType.INSERT)
    public boolean save(Employee employee){
        return employeeMapper.insertSelective(employee) > 0;
    }

    @OperationLogDetail(detail = "根据ID删除员工",level = 4,operationUnit = OperationUnit.EMPLOYEE,operationType = OperationType.DELETE)
    public boolean remove(Integer id){
        return employeeMapper.deleteByPrimaryKey(id) > 0;
    }

    @OperationLogDetail(detail = "更新员工",level = 2,operationUnit = OperationUnit.EMPLOYEE,operationType = OperationType.UPDATE)
    public boolean update(Employee employee){
        return employeeMapper.updateByPrimaryKeySelective(employee) > 0;
    }

    @OperationLogDetail(detail = "根据ID查询员工",level = 1,operationUnit = OperationUnit.EMPLOYEE,operationType = OperationType.SELECT)
    public Employee findById(Integer id){
        return employeeMapper.selectByPrimaryKey(id);
    }

    @OperationLogDetail(detail = "根据工号查询员工",level = 1,operationUnit = OperationUnit.EMPLOYEE,operationType = OperationType.SELECT)
    public Employee findByNO(String empNO){
        return employeeMapper.selectByEmpNO(empNO);
    }

    @OperationLogDetail(detail = "查询员工列表",level = 1,operationUnit = OperationUnit.EMPLOYEE,operationType = OperationType.SELECT)
    public PageInfo findAll(int page, int size, String name, String no,String deptId){
        PageHelper.startPage(page,size);
        List<Employee> employees = employeeMapper.findAll(name,no,deptId);
        PageInfo pageInfo = new PageInfo(employees);
        pageInfo.setList(employees);
        return pageInfo;
    }
}
