package com.hopu.phone_admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hopu.phone_admin.dao.ModuleMapper;
import com.hopu.phone_admin.dao.RoleModuleMapper;
import com.hopu.phone_admin.entity.Module;
import com.hopu.phone_admin.entity.ModuleTreeNode;
import com.hopu.phone_admin.entity.RoleModule;
import com.hopu.phone_admin.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements IModuleService {

    @Autowired
    private ModuleMapper moduleMapper;
    @Autowired
    private RoleModuleMapper roleModuleMapper;

    @Override
    public List<ModuleTreeNode> getModuleTreeNodeByAccount(String account) {
        return moduleMapper.selectModuleTreeNodeByAccount(account);
    }

    @Override
    public List<ModuleTreeNode> getModuleTreeNodeByRoleName(String roleName) {
        return moduleMapper.selectModuleTreeNodeByRoleName(roleName);
    }

    //角色授权
    @Override
    public void grantModuleToRole(String moduleName, String roleId) {
        //如果添加的是子级权限，应该同时添加其父级权限
        Module module = moduleMapper.selectOne(new QueryWrapper<Module>().eq("module_name", moduleName));
        if (module == null){
            throw new RuntimeException("该权限名称不存在");
        }
        //判断子权限在中间表是否存在
        Integer count = roleModuleMapper.selectCount(new QueryWrapper<RoleModule>().eq("module_id", module.getModuleCode()).eq("role_id", roleId));
        if (count > 0){
            throw new RuntimeException("此角色已添加该权限");
        }
        //添加权限
        RoleModule roleModule = new RoleModule(0, module.getModuleCode(), roleId);
        roleModuleMapper.insert(roleModule);
        String parentModule = module.getParentModule();
        if(!parentModule.equals("01") && !parentModule.equals("0101")){
            //判断父权限在中间表是否存在
            count = roleModuleMapper.selectCount(new QueryWrapper<RoleModule>().eq("module_id",parentModule).eq("role_id", roleId));
            //不存在就添加父权限
            if (count == 0){
                roleModuleMapper.insert(new RoleModule(0,parentModule,roleId));
            }
        }
    }

    @Override
    public void removeModuleFromRole(String moduleName, String roleId) {
        //如果删除的是父级权限，应该同时删除其子级权限
        Module module = moduleMapper.selectOne(new QueryWrapper<Module>().eq("module_name", moduleName));
        if (module == null){
            throw new RuntimeException("该权限名称不存在");
        }
        //删除权限和子权限
        roleModuleMapper.delete(new QueryWrapper<RoleModule>().like("module_id",module.getModuleCode()+"%"));
    }
}
