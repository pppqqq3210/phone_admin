package com.hopu.phone_admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_role")
public class Role {

  @TableId(type = IdType.INPUT)
  private String roleId;
  private String roleName;
  private String roleDesc;
  private long roleOrder;
  private long roleType;


  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


  public String getRoleDesc() {
    return roleDesc;
  }

  public void setRoleDesc(String roleDesc) {
    this.roleDesc = roleDesc;
  }


  public long getRoleOrder() {
    return roleOrder;
  }

  public void setRoleOrder(long roleOrder) {
    this.roleOrder = roleOrder;
  }


  public long getRoleType() {
    return roleType;
  }

  public void setRoleType(long roleType) {
    this.roleType = roleType;
  }

}
