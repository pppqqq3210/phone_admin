package com.hopu.phone_admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hopu.phone_admin.entity.Module;
import com.hopu.phone_admin.entity.ModuleTreeNode;

import java.util.List;

/**
 * 模块权限映射
 */
public interface ModuleMapper extends BaseMapper<Module> {

    /**
     * 通过用户名查询所有的模块（权限）
     * @param account
     * @return
     */
    List<Module> selectModulesByAccount(String account);

    /**
     * 通过用户名查询两级模块菜单
     * @param account
     * @return
     */
    List<ModuleTreeNode> selectModuleTreeNodeByAccount(String account);

    /**
     * 通过角色名称查询模块菜单
     * @param roleName
     * @return
     */
    List<ModuleTreeNode> selectModuleTreeNodeByRoleName(String roleName);
}
