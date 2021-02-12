package cn.xhu.core.pojo;

import java.sql.Date;

public class Menu {

  /**
   * 主键ID
   */
  private long id;
  /**
   * 父级ID
   */
  private long parentId;
  /**
   * 菜单名称
   */
  private String menuName;
  /**
   * url
   */
  private String url;
  /**
   * 授权
   */
  private String perms;
  /**
   * 类型：0目录 1菜单 2按钮
   */
  private long type;
  /**
   * 排序
   */
  private long orderNum;
  /**
   * 备注
   */
  private String remark;
  /**
   * 路由名称
   */
  private String routerName;
  /**
   * 路由路径
   */
  private String routerPath;
  /**
   * 操作人员
   */
  private String operator;
  /**
   * 是否删除：0未删除 1删除
   */
  private long isDelete;
  /**
   * 更新时间
   */
  private Date createTime;
  /**
   *更新时间
   */
  private Date updateTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }


  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public String getPerms() {
    return perms;
  }

  public void setPerms(String perms) {
    this.perms = perms;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public long getOrderNum() {
    return orderNum;
  }

  public void setOrderNum(long orderNum) {
    this.orderNum = orderNum;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public String getRouterName() {
    return routerName;
  }

  public void setRouterName(String routerName) {
    this.routerName = routerName;
  }


  public String getRouterPath() {
    return routerPath;
  }

  public void setRouterPath(String routerPath) {
    this.routerPath = routerPath;
  }


  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
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
