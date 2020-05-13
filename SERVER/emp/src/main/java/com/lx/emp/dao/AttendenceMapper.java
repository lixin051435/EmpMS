package com.lx.emp.dao;

import com.lx.emp.pojo.Attendence;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AttendenceMapper {
    int deleteByPrimaryKey(Integer attendId);

    int insert(Attendence record);

    int insertSelective(Attendence record);

    Attendence selectByPrimaryKey(Integer attendId);

    @Select("select * from tb_attend where emp_no = #{no} and attend_begin_time between #{begin} and #{end}")
    Attendence getByEmpNoAndBeginTime(@Param("no") String no, @Param("begin") String begin,@Param("end") String end);

    @Select("select * from tb_attend where emp_no = #{no} and attend_end_time between #{begin} and #{end}")
    Attendence getByEmpNoAndEndTime(@Param("no") String no, @Param("begin") String begin,@Param("end") String end);

    int updateByPrimaryKeySelective(Attendence record);

    int updateByPrimaryKey(Attendence record);

    @Select("select * from tb_attend where emp_no like concat('%',#{no},'%') and emp_name like concat('%',#{name},'%')")
    List<Attendence> findAll(@Param("name") String name, @Param("no") String no);
}