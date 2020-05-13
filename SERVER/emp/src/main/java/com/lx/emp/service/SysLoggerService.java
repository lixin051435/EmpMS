package com.lx.emp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lx.emp.dao.SaleryMapper;
import com.lx.emp.dao.SysLoggerMapper;
import com.lx.emp.pojo.Salery;
import com.lx.emp.pojo.SysLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysLoggerService {
    
    @Autowired
    private SysLoggerMapper sysLoggerMapper;



    public PageInfo<SysLogger> findAll(int page, int size){
        PageHelper.startPage(page,size);
        List<SysLogger> sysLoggers = sysLoggerMapper.findAll();
        PageInfo pageInfo = new PageInfo(sysLoggers);
        pageInfo.setList(sysLoggers);
        return pageInfo;
    }

    public boolean remove(Integer id) {
        return sysLoggerMapper.deleteByPrimaryKey(id) > 0;
    }
}
