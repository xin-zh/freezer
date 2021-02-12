package cn.xhu.core.pojo;

import java.sql.Date;

public class User {

  /**
   * 主键ID
   */
  private long id;
  /**
   * 员工姓名
   */
  private String userName;
  /**
   * 员工密码
   */
  private String password;
  /**
   * 真实姓名
   */
  private String realName;
  /**
   * 性别：1男 2女 3保密
   */
  private long sex;
  /**
   * 员工家庭住址
   */
  private String address;
  /**
   * 员工证件信息
   */
  private String identify;
  /**
   * 员工电话
   */
  private String userTel;
  /**
   * 员工邮箱
   */
  private String email;
  /**
   * 是否删除：0未删除 1删除
   */
  private long isDelete;
  /**
   * 创建时间
   */
  private Date createTime;
  /**
   * 更新时间
   */
  private Date updateTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }


  public long getSex() {
    return sex;
  }

  public void setSex(long sex) {
    this.sex = sex;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getIdentify() {
    return identify;
  }

  public void setIdentify(String identify) {
    this.identify = identify;
  }


  public String getUserTel() {
    return userTel;
  }

  public void setUserTel(String userTel) {
    this.userTel = userTel;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public long getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(long isDelete) {
    this.isDelete = isDelete;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

}
