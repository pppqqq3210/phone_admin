package com.hopu.phone_admin;

import com.hopu.phone_admin.dao.ModuleMapper;
import com.hopu.phone_admin.dao.RoleMapper;
import com.hopu.phone_admin.dao.UserMapper;
import com.hopu.phone_admin.entity.Module;
import com.hopu.phone_admin.entity.Role;
import com.hopu.phone_admin.entity.User;
import com.hopu.phone_admin.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTest {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ModuleMapper moduleMapper;

    @Test
    public void testSelectRoles(){
        List<Role> roles = roleMapper.selectRolesByAccount("admin");
        roles.forEach(role -> System.out.println(role));
    }

    @Test
    public void testSelectModules(){
        List<Module> modules = moduleMapper.selectModulesByAccount("xiaowei");
        modules.forEach(module -> System.out.println(module));
    }

}
