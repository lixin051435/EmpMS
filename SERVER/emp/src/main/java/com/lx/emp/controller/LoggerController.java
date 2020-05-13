package com.lx.emp.controller;

import com.github.pagehelper.PageInfo;
import com.lx.emp.pojo.Salery;
import com.lx.emp.pojo.SysLogger;
import com.lx.emp.service.SaleryService;
import com.lx.emp.service.SysLoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log")
@CrossOrigin
public class LoggerController {

    @Autowired
    private SysLoggerService sysLoggerService;

    @GetMapping("/list")
    public PageInfo<SysLogger> list(@RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "5") int size) {
        return sysLoggerService.findAll(page, size);
    }

    @DeleteMapping("/remove/{id}")
    public boolean remove(@PathVariable Integer id){
        return sysLoggerService.remove(id);
    }


}