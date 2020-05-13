package com.lx.emp.service;

import com.lx.emp.annotation.OperationLogDetail;
import com.lx.emp.dao.DepartmentMapper;
import com.lx.emp.enums.OperationType;
import com.lx.emp.enums.OperationUnit;
import com.lx.emp.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @OperationLogDetail(detail = "增加部门",level = 3,operationUnit = OperationUnit.DEPARTMENT,operationType = OperationType.INSERT)
    public boolean save( Department department){
        return departmentMapper.insert(department) > 0;
    }

    @OperationLogDetail(detail = "根据ID删除部门",level = 4,operationUnit = OperationUnit.DEPARTMENT,operationType = OperationType.DELETE)
    public boolean remove(String deptId){
        return departmentMapper.deleteByPrimaryKey(deptId) > 0;
    }

    @OperationLogDetail(detail = "更改部门信息",level = 2,operationUnit = OperationUnit.DEPARTMENT,operationType = OperationType.UPDATE)
    public boolean update( Department department){
        return departmentMapper.updateByPrimaryKeySelective(department) > 0;
    }

    @OperationLogDetail(detail = "通过部门ID获取部门列表",level = 1,operationUnit = OperationUnit.DEPARTMENT,operationType = OperationType.SELECT)
    public Department findById(String deptId){
        return departmentMapper.selectByPrimaryKey(deptId);
    }

    @OperationLogDetail(detail = "通过部门名称获取部门列表",level = 1,operationUnit = OperationUnit.DEPARTMENT,operationType = OperationType.SELECT)
    public List<Department> findAll(String departmentName){
        if(departmentName == null){
            departmentName = "";
        }
        return departmentMapper.findAll(departmentName);
    }
}
