package com.hopu.phone_admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_module")
public class Module {

  @TableId(type = IdType.INPUT)
  private String moduleId;
  private String moduleCode;
  private String moduleName;
  private String linkUrl;
  private long moduleOrder;
  private String parentModule;
  private String moduleDesc;
  private String expanded;
  private String leaf;


  public String getModuleId() {
    return moduleId;
  }

  public void setModuleId(String moduleId) {
    this.moduleId = moduleId;
  }


  public String getModuleCode() {
    return moduleCode;
  }

  public void setModuleCode(String moduleCode) {
    this.moduleCode = moduleCode;
  }


  public String getModuleName() {
    return moduleName;
  }

  public void setModuleName(String moduleName) {
    this.moduleName = moduleName;
  }


  public String getLinkUrl() {
    return linkUrl;
  }

  public void setLinkUrl(String linkUrl) {
    this.linkUrl = linkUrl;
  }


  public long getModuleOrder() {
    return moduleOrder;
  }

  public void setModuleOrder(long moduleOrder) {
    this.moduleOrder = moduleOrder;
  }


  public String getParentModule() {
    return parentModule;
  }

  public void setParentModule(String parentModule) {
    this.parentModule = parentModule;
  }


  public String getModuleDesc() {
    return moduleDesc;
  }

  public void setModuleDesc(String moduleDesc) {
    this.moduleDesc = moduleDesc;
  }


  public String getExpanded() {
    return expanded;
  }

  public void setExpanded(String expanded) {
    this.expanded = expanded;
  }


  public String getLeaf() {
    return leaf;
  }

  public void setLeaf(String leaf) {
    this.leaf = leaf;
  }

}
