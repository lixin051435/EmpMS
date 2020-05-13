package com.lx.emp.controller;

import com.lx.emp.pojo.Role;
import com.lx.emp.service.PermissionService;
import com.lx.emp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/list")
    public List<Role> list() {
        return roleService.findAll();
    }


    @PostMapping("/save")
    public boolean save(@RequestBody Role role) {
        return roleService.save(role);
    }

    @DeleteMapping("/remove/{id}")
    public boolean remove(@PathVariable String id) {
        return roleService.remove(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Role role) {
        return roleService.update(role);
    }

    @GetMapping("/get/{id}")
    public Role getOne(@PathVariable String id) {
        return roleService.findById(id);
    }


    @GetMapping("/addpermission")
    public boolean addPermissions(@RequestParam("roleId") String roleId,
                                  @RequestParam("permissionIds") String permissionIds) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(permissionIds.split(",")));
        return permissionService.addPermissions(roleId, list);
    }
}