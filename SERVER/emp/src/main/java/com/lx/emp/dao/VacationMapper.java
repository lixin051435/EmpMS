package com.lx.emp.dao;

import com.lx.emp.pojo.Vacation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VacationMapper {
    int deleteByPrimaryKey(Integer vacationId);

    int insert(Vacation record);

    int insertSelective(Vacation record);

    Vacation selectByPrimaryKey(Integer vacationId);

    int updateByPrimaryKeySelective(Vacation record);

    int updateByPrimaryKey(Vacation record);

    @Select("select * from tb_vacation where emp_no like concat('%',#{no},'%') and emp_name like concat('%',#{name},'%')")

    List<Vacation> findAll(@Param("name") String name, @Param("no")String no);

    @Select("select * from tb_vacation where emp_no = #{no}")
    List<Vacation> findAllByEmpNo(@Param("no") String no);

    @Select("select * from tb_vacation where status = #{status} and emp_no like concat('%',#{no},'%') and emp_name like concat('%',#{name},'%')")
    List<Vacation> findAllByStatus(@Param("name") String name, @Param("no")String no,@Param("status") int status);


}