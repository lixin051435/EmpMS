package com.lx.emp.service;

import com.lx.emp.annotation.OperationLogDetail;
import com.lx.emp.dao.RoleMapper;
import com.lx.emp.enums.OperationType;
import com.lx.emp.enums.OperationUnit;
import com.lx.emp.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @OperationLogDetail(detail = "增加权限",level = 2,operationUnit = OperationUnit.ROLE,operationType = OperationType.INSERT)
    public boolean save( Role role){
        return roleMapper.insert(role) > 0;
    }

    @OperationLogDetail(detail = "删除权限",level = 4,operationUnit = OperationUnit.ROLE,operationType = OperationType.DELETE)
    public boolean remove(String roleId){
        return roleMapper.deleteByPrimaryKey(roleId) > 0;
    }

    @OperationLogDetail(detail = "修改权限",level = 3,operationUnit = OperationUnit.ROLE,operationType = OperationType.UPDATE)
    public boolean update( Role role){
        return roleMapper.updateByPrimaryKeySelective(role) > 0;
    }

    @OperationLogDetail(detail = "根据ID查询权限",level = 1,operationUnit = OperationUnit.ROLE,operationType = OperationType.SELECT)
    public Role findById(String roleId){
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @OperationLogDetail(detail = "查询权限列表",level = 1,operationUnit = OperationUnit.ROLE,operationType = OperationType.SELECT)
    public List<Role> findAll(){
        return roleMapper.findAll();
    }
}
