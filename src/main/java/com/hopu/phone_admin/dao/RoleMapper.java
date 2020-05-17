package com.hopu.phone_admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hopu.phone_admin.entity.Role;

import java.util.List;

/**
 * 角色映射接口
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据账号查询用户所有的角色
     * @param account
     * @return
     */
    List<Role> selectRolesByAccount(String account);
}