package com.lx.emp.dao;

import com.lx.emp.pojo.Department;
import com.lx.emp.pojo.Salery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaleryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salery record);

    int insertSelective(Salery record);

    Salery selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salery record);

    int updateByPrimaryKey(Salery record);

    @Select("select * from tb_salery where emp_name like concat('%',#{empName},'%') and emp_no like concat('%',#{no},'%')")
    List<Salery> findAll(@Param("empName") String empName, @Param("no")String no);
}