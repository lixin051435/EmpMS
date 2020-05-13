package com.lx.emp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lx.emp.annotation.OperationLogDetail;
import com.lx.emp.dao.VacationMapper;
import com.lx.emp.enums.OperationType;
import com.lx.emp.enums.OperationUnit;
import com.lx.emp.pojo.Employee;
import com.lx.emp.pojo.Vacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationService {
    
    @Autowired
    private VacationMapper vacationMapper;

    @Autowired
    private EmployeeService employeeService;

    @OperationLogDetail(detail = "增加休假信息",level = 2,operationUnit = OperationUnit.VACATION,operationType = OperationType.INSERT)
    public boolean save(Vacation cacation){
        return vacationMapper.insertSelective(cacation) > 0;
    }

    @OperationLogDetail(detail = "根据ID删除休假信息",level = 4,operationUnit = OperationUnit.VACATION,operationType = OperationType.DELETE)
    public boolean remove(Integer id){
        return vacationMapper.deleteByPrimaryKey(id) > 0;
    }

    @OperationLogDetail(detail = "修改休假信息",level = 3,operationUnit = OperationUnit.VACATION,operationType = OperationType.UPDATE)
    public boolean update(Vacation cacation){
        return vacationMapper.updateByPrimaryKeySelective(cacation) > 0;
    }

    @OperationLogDetail(detail = "根据ID查询休假信息",level = 1,operationUnit = OperationUnit.VACATION,operationType = OperationType.SELECT)
    public Vacation findById(Integer id){
        return vacationMapper.selectByPrimaryKey(id);
    }


    @OperationLogDetail(detail = "查询休假信息列表",level = 1,operationUnit = OperationUnit.VACATION,operationType = OperationType.SELECT)
    public PageInfo<Vacation> findAll(int page, int size, String name, String no){
        PageHelper.startPage(page,size);
        List<Vacation> vacations = vacationMapper.findAll(name,no);
        PageInfo<Vacation> pageInfo = new PageInfo<>(vacations);
        pageInfo.setList(vacations);
        return pageInfo;
    }

    @OperationLogDetail(detail = "查询自己的休假信息",level = 1,operationUnit = OperationUnit.VACATION,operationType = OperationType.SELECT)
    public PageInfo<Vacation> findMyVacations(int page, int size, String no){
        PageHelper.startPage(page,size);
        List<Vacation> vacations = vacationMapper.findAllByEmpNo(no);
        PageInfo<Vacation> pageInfo = new PageInfo<>(vacations);
        pageInfo.setList(vacations);
        return pageInfo;
    }

    @OperationLogDetail(detail = "查询已经提交的休假信息",level = 1,operationUnit = OperationUnit.VACATION,operationType = OperationType.SELECT)
    public PageInfo<Vacation> findCommitedVacations(int page, int size,  String name, String no,int status){
        PageHelper.startPage(page,size);
        List<Vacation> vacations = vacationMapper.findAllByStatus(name,no,status);
        PageInfo<Vacation> pageInfo = new PageInfo<>(vacations);
        pageInfo.setList(vacations);
        return pageInfo;
    }


}
