package com.lx.emp.dao;

import com.lx.emp.pojo.RolePermission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

    @Delete("delete from r_role_permission where role_id = #{roleId}")
    void deleteByRoleId(@Param("roleId") String roleId);
}