package com.lx.emp.dao;

import com.lx.emp.pojo.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    @Select("SELECT p.* from r_role_permission rp,tb_permission p where rp.role_id = #{roleid} and rp.permission_id = p.permission_id")
    List<Permission> findByRoleId(@Param("roleid") String roleid);

    @Select("select * from tb_permission")
    List<Permission> findAll();

}