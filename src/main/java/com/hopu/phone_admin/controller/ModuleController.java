package com.hopu.phone_admin.controller;

import com.hopu.phone_admin.entity.JsonResult;
import com.hopu.phone_admin.entity.ModuleTreeNode;
import com.hopu.phone_admin.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("module")
public class ModuleController {

    @Autowired
    private IModuleService moduleService;

    @GetMapping("getModuleTreeNodes")
    public JsonResult getModuleTreeNodes(String account){
        try {
            List<ModuleTreeNode> nodes = moduleService.getModuleTreeNodeByAccount(account);
            return new JsonResult(200,"success",nodes);
        }catch (Exception ex){
            ex.printStackTrace();
            return new JsonResult(500,"failed",null);
        }
    }
    @GetMapping("getRoleModuleTreeNodes")
    public JsonResult getRoleModuleTreeNodes(String roleName){
        try {
            List<ModuleTreeNode> nodes = moduleService.getModuleTreeNodeByRoleName(roleName);
            for(ModuleTreeNode node : nodes){
                boolean isChecked = false;
                //判断当前节点的子节点是否选中
                for(ModuleTreeNode childNode : node.getNodes()){
                    if(childNode.isChecked()){
                        childNode.getState().setChecked(true);
                        isChecked = true;
                    }
                }
                //子节点选中父节点也应该选中
                if(isChecked){
                    node.getState().setChecked(true);
                }
            }
            return new JsonResult(200,"success",nodes);
        }catch (Exception ex){
            ex.printStackTrace();
            return new JsonResult(500,"failed",null);
        }
    }
}