package com.lx.emp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lx.emp.annotation.OperationLogDetail;
import com.lx.emp.dao.SaleryMapper;
import com.lx.emp.enums.OperationType;
import com.lx.emp.enums.OperationUnit;
import com.lx.emp.pojo.Salery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SaleryService {
    
    @Autowired
    private SaleryMapper saleryMapper;


    @OperationLogDetail(detail = "增加工资信息",level = 2,operationUnit = OperationUnit.SALERY,operationType = OperationType.INSERT)
    public boolean save(Salery salery){
        salery.setCreatetime(new Date());
        salery.setTotal(salery.getWorkSalery().add(salery.getReward()).add(salery.getAllowance()).subtract(salery.getAbsent()).subtract(salery.getVacation()));
        return saleryMapper.insertSelective(salery) > 0;
    }

    @OperationLogDetail(detail = "删除工资信息",level = 4,operationUnit = OperationUnit.SALERY,operationType = OperationType.DELETE)
    public boolean remove(Integer id){
        return saleryMapper.deleteByPrimaryKey(id) > 0;
    }

    @OperationLogDetail(detail = "修改工资信息",level = 3,operationUnit = OperationUnit.SALERY,operationType = OperationType.UPDATE)
    public boolean update(Salery salery){
        salery.setTotal(salery.getWorkSalery().add(salery.getReward()).add(salery.getAllowance()).subtract(salery.getAbsent()).subtract(salery.getVacation()));
        return saleryMapper.updateByPrimaryKeySelective(salery) > 0;
    }

    @OperationLogDetail(detail = "根据ID查询工资信息",level = 1,operationUnit = OperationUnit.SALERY,operationType = OperationType.SELECT)
    public Salery findById(Integer id){
        return saleryMapper.selectByPrimaryKey(id);
    }


    @OperationLogDetail(detail = "查询工资信息列表",level = 1,operationUnit = OperationUnit.SALERY,operationType = OperationType.SELECT)
    public PageInfo findAll(int page, int size, String name, String no){
        PageHelper.startPage(page,size);
        List<Salery> salerys = saleryMapper.findAll(name,no);
        PageInfo pageInfo = new PageInfo(salerys);
        pageInfo.setList(salerys);
        return pageInfo;
    }
}
