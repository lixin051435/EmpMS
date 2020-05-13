package com.lx.emp.controller;

import com.github.pagehelper.PageInfo;
import com.lx.emp.enums.VacationStatusEnum;
import com.lx.emp.pojo.Department;
import com.lx.emp.pojo.Vacation;
import com.lx.emp.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/vacation")
public class VacationController {

    @Autowired
    private VacationService vacationService;

    @GetMapping("/list")
    public PageInfo<Vacation> list(@RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "5") int size,
                                   @RequestParam(defaultValue = "") String name,
                                   @RequestParam(defaultValue = "") String no) {
        return vacationService.findAll(page, size, name, no);
    }

    @GetMapping("/mylist")
    public PageInfo<Vacation> mylist(@RequestParam(defaultValue = "1") int page,
                                     @RequestParam(defaultValue = "5") int size,
                                     @RequestParam(defaultValue = "") String no) {
        return vacationService.findMyVacations(page, size, no);
    }

    @GetMapping("/processlist")
    public PageInfo<Vacation> processlist(@RequestParam(defaultValue = "1") int page,
                                          @RequestParam(defaultValue = "5") int size,
                                          @RequestParam(defaultValue = "") String name,
                                          @RequestParam(defaultValue = "") String no
                                          ) {
        int status = VacationStatusEnum.COMMITED.getCode();
        return vacationService.findCommitedVacations(page, size, name, no, status);
    }

    @DeleteMapping("/remove/{id}")
    public boolean remove(@PathVariable Integer id) {
        return vacationService.remove(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Vacation vacation) {
        return vacationService.update(vacation);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Vacation vacation) {
        return vacationService.save(vacation);
    }

}
