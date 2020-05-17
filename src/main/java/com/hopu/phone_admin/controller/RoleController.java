package com.hopu.phone_admin.controller;

import com.hopu.phone_admin.entity.Role;
import com.hopu.phone_admin.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("role-list")
    public String listRoles(Model model){
        List<Role> roles = roleService.list();
        model.addAttribute("roles",roles);
        return "role-list";
    }
}
