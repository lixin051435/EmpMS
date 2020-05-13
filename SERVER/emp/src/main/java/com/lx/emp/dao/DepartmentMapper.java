package com.lx.emp.dao;

import com.lx.emp.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String deptId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String deptId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    @Select("select * from tb_dept where dept_name like concat('%',#{departmentName},'%')")
    List<Department> findAll(@Param("departmentName") String departmentName);
}