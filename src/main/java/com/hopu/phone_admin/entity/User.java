package com.hopu.phone_admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_user")
public class User {

  @TableId(type = IdType.INPUT)
  private String userId;
  private String userName;
  private String userLoginAccount;
  private String userLoginPwd;
  private String remark;
  private String userType;
  private String enabled;
  private String loginTime;
  private String roleId;
  private String userIcon;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserLoginAccount() {
    return userLoginAccount;
  }

  public void setUserLoginAccount(String userLoginAccount) {
    this.userLoginAccount = userLoginAccount;
  }

  public String getUserLoginPwd() {
    return userLoginPwd;
  }

  public void setUserLoginPwd(String userLoginPwd) {
    this.userLoginPwd = userLoginPwd;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getEnabled() {
    return enabled;
  }

  public void setEnabled(String enabled) {
    this.enabled = enabled;
  }

  public String getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(String loginTime) {
    this.loginTime = loginTime;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getUserIcon() {
    return userIcon;
  }

  public void setUserIcon(String userIcon) {
    this.userIcon = userIcon;
  }
}
