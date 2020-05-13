package com.lx.emp.controller;

import com.github.pagehelper.PageInfo;
import com.lx.emp.pojo.Attendence;
import com.lx.emp.pojo.Employee;
import com.lx.emp.service.AttendenceService;
import com.lx.emp.service.EmployeeService;
import com.lx.emp.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/attend")
public class AttendenceController {
    @Autowired
    private AttendenceService attendenceService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public PageInfo list(@RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "5") int size,
                         @RequestParam(defaultValue = "") String name,
                         @RequestParam(defaultValue = "") String no
                         ){
        return attendenceService.findAll(page,size,name,no);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Attendence attendence){
        String no = attendence.getEmpNo();
        Employee employee = employeeService.findByNO(no);
        attendence.setEmpName(employee.getEmpName());

        String begin = DateUtils.format(new Date());
        String end = begin + " 23:59:59";
        Attendence shangban = attendenceService.getByEmpNoAndBeginTime(no,begin,end);
        Attendence xiaban = attendenceService.getByEmpNoAndBeginTime(no,begin,end);
        if(shangban != null || xiaban != null){
            return false;
        }
        return attendenceService.save(attendence);
    }

    @GetMapping("/shangban")
    public boolean shangban(String no){
        Employee employee = employeeService.findByNO(no);
        Attendence attendence = new Attendence();
        attendence.setEmpNo(no);
        attendence.setEmpName(employee.getEmpName());

        String begin = DateUtils.format(new Date());
        String end = begin + " 23:59:59";
        Attendence shangban = attendenceService.getByEmpNoAndBeginTime(no,begin,end);
        if(shangban != null ){
            return false;
        }else{
            attendence.setAttendBeginTime(new Date());
            return attendenceService.save(attendence);
        }

    }

    @GetMapping("/canshangban")
    public boolean canshangban(String no){
        String begin = DateUtils.format(new Date());
        String end = begin + " 23:59:59";
        Attendence shangban = attendenceService.getByEmpNoAndBeginTime(no,begin,end);
        if(shangban != null ){
            return false;
        }else{
            return true;
        }

    }

    @GetMapping("/xiaban")
    public boolean xiaban(String no){
        Employee employee = employeeService.findByNO(no);
        Attendence attendence = new Attendence();
        attendence.setEmpNo(no);
        attendence.setEmpName(employee.getEmpName());

        String begin = DateUtils.format(new Date());
        String end = begin + " 23:59:59";
        Attendence shangban = attendenceService.getByEmpNoAndBeginTime(no,begin,end);
        Attendence xiaban = attendenceService.getByEmpNoAndEndTime(no,begin,end);
        if(shangban != null && xiaban == null ){
            shangban.setAttendEndTime(new Date());
            return attendenceService.update(shangban);
        }
        return false;

    }
    @GetMapping("/canxiaban")
    public boolean canxiaban(String no){
        String begin = DateUtils.format(new Date());
        String end = begin + " 23:59:59";
        Attendence shangban = attendenceService.getByEmpNoAndBeginTime(no,begin,end);
        Attendence xiaban = attendenceService.getByEmpNoAndEndTime(no,begin,end);
        if(shangban != null && xiaban == null ){
            return true;
        }
        return false;

    }

    @DeleteMapping("/remove/{id}")
    public boolean remove(@PathVariable Integer id){
        return attendenceService.remove(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Attendence attendence){
        return attendenceService.update(attendence);
    }
}
