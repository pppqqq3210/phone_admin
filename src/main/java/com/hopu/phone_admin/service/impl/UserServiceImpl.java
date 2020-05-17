package com.hopu.phone_admin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hopu.phone_admin.dao.UserMapper;
import com.hopu.phone_admin.entity.User;
import com.hopu.phone_admin.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {
}
