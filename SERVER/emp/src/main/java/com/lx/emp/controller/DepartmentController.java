package com.lx.emp.controller;

import com.lx.emp.pojo.Department;
import com.lx.emp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/department")
@CrossOrigin
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/list")
    public List<Department> list(@RequestParam(required = false) String departmentName){
        return departmentService.findAll(departmentName);
    }


    @PostMapping("/save")
    public boolean save(@RequestBody Department department){
        department.setDeptCreateTime(new Date());
        return departmentService.save(department);
    }

    @DeleteMapping("/remove/{id}")
    public boolean remove(@PathVariable String id){
        return departmentService.remove(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Department department){
        return departmentService.update(department);
    }

    @GetMapping("/get/{id}")
    public Department getOne(@PathVariable String id){
        return departmentService.findById(id);
    }}
