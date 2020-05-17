package com.hopu.phone_admin;

import com.hopu.phone_admin.dao.UserMapper;
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
public class PhoneAdminApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> users = userMapper.selectList(null);
        users.forEach((user)-> System.out.println(user));

        List<User> list = userService.list();
        list.forEach((user -> System.out.println(user)));
    }

}
