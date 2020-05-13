package com.lx.emp.dao;

import com.lx.emp.pojo.SysLogger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysLoggerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysLogger record);

    int insertSelective(SysLogger record);

    SysLogger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysLogger record);

    int updateByPrimaryKeyWithBLOBs(SysLogger record);

    int updateByPrimaryKey(SysLogger record);

    @Select("select * from sys_logger")
    List<SysLogger> findAll();
}