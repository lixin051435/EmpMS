package com.lx.emp.controller;

import com.github.pagehelper.PageInfo;
import com.lx.emp.pojo.Employee;
import com.lx.emp.pojo.Permission;
import com.lx.emp.service.EmployeeService;
import com.lx.emp.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PermissionService permisssionService;



    @GetMapping("/list")
    public PageInfo list(@RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "5") int size,
                               @RequestParam(defaultValue = "") String name,
                               @RequestParam(defaultValue = "") String no,
                               @RequestParam(defaultValue = "") String deptId){
        return employeeService.findAll(page,size,name,no,deptId);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/remove/{id}")
    public boolean remove(@PathVariable Integer id){
        return employeeService.remove(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @GetMapping("/get/{empNo}")
    public Employee getOne(@PathVariable String empNo){
        return employeeService.findByNO(empNo);
    }

    @PostMapping("/login")
    public Employee login(@RequestBody Employee form){
        Employee employee = employeeService.findByNO(form.getEmpNo());
        List<Permission> permissions = permisssionService.findByRoleId(employee.getEmpType());
        employee.setPermissions(permissions);
        if(employee != null){
            if(form.getEmpPassword().equals(employee.getEmpPassword())){
                return employee;
            }
        }
        return null;
    }

    @PostMapping("/changePass")
    public Boolean changePassword( @RequestBody Employee employee){
        return employeeService.changePassword(employee.getEmpNo(),employee.getEmpPassword());
    }

}
