package com.lx.emp.service;

import com.lx.emp.annotation.OperationLogDetail;
import com.lx.emp.dao.PermissionMapper;
import com.lx.emp.dao.RolePermissionMapper;
import com.lx.emp.enums.OperationType;
import com.lx.emp.enums.OperationUnit;
import com.lx.emp.pojo.Permission;
import com.lx.emp.pojo.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @OperationLogDetail(detail = "增加权限",level = 2,operationUnit = OperationUnit.PERMISSION,operationType = OperationType.INSERT)
    public boolean save( Permission permission){
        return permissionMapper.insert(permission) > 0;
    }

    @OperationLogDetail(detail = "修改权限",level = 3,operationUnit = OperationUnit.PERMISSION,operationType = OperationType.UPDATE)
    public boolean update( Permission permission){
        return permissionMapper.updateByPrimaryKeySelective(permission) > 0;
    }

    @OperationLogDetail(detail = "根据ID查询权限",level = 1,operationUnit = OperationUnit.PERMISSION,operationType = OperationType.SELECT)
    public Permission findById(Integer id){
        return permissionMapper.selectByPrimaryKey(id);
    }

    @OperationLogDetail(detail = "根据角色ID查询权限",level = 1,operationUnit = OperationUnit.PERMISSION,operationType = OperationType.SELECT)
    public List<Permission> findByRoleId(String roleId){
        return permissionMapper.findByRoleId(roleId);
    }

    @OperationLogDetail(detail = "查询权限列表",level = 1,operationUnit = OperationUnit.PERMISSION,operationType = OperationType.SELECT)
    public List<Permission> findAll(){
        return permissionMapper.findAll();
    }

    @OperationLogDetail(detail = "批量修改权限",level = 2,operationUnit = OperationUnit.PERMISSION,operationType = OperationType.INSERT)
    public boolean addPermissions(String roleId,List<String> permissionIds){

        rolePermissionMapper.deleteByRoleId(roleId);
        for (int i = 0; i < permissionIds.size(); i++) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(Integer.parseInt(permissionIds.get(i)));
            rolePermissionMapper.insertSelective(rolePermission);
        }
        return true;

    }
}
