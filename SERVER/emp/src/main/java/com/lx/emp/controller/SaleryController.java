package com.lx.emp.controller;

import com.github.pagehelper.PageInfo;
import com.lx.emp.pojo.Salery;
import com.lx.emp.service.SaleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/salery")
@CrossOrigin
public class SaleryController {

    @Autowired
    private SaleryService saleryService;

    @GetMapping("/list")
    public PageInfo<Salery> list(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "5") int size,
                                 @RequestParam(defaultValue = "") String name,
                                 @RequestParam(defaultValue = "") String no){
        return saleryService.findAll(page,size,name,no);
    }


    @PostMapping("/save")
    public boolean save(@RequestBody Salery salery){
        return saleryService.save(salery);
    }

    @DeleteMapping("/remove/{id}")
    public boolean remove(@PathVariable Integer id){
        return saleryService.remove(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Salery salery){
        return saleryService.update(salery);
    }

    @GetMapping("/get/{id}")
    public Salery getOne(@PathVariable Integer id){
        return saleryService.findById(id);
    }}
