package com.hopu.phone_admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hopu.phone_admin.dao.ModuleMapper;
import com.hopu.phone_admin.entity.Module;
import com.hopu.phone_admin.entity.ModuleTreeNode;
import com.hopu.phone_admin.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements IModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public List<ModuleTreeNode> getModuleTreeNodeByAccount(String account) {
        return moduleMapper.selectModuleTreeNodeByAccount(account);
    }

    @Override
    public List<ModuleTreeNode> getModuleTreeNodeByRoleName(String roleName) {
        return moduleMapper.selectModuleTreeNodeByRoleName(roleName);
    }
}
