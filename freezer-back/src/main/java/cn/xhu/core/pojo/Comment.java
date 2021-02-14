package cn.xhu.core.pojo;

import java.sql.Date;

/**
 * 评论信息表
 */
public class Comment {

  /**
   * 主键ID
   */
  private long id;
  /**
   * 订单序列号
   */
  private String orderNo;
  /**
   * 用户序列号（账号）
   */
  private String customerName;
  /**
   * 评论内容
   */
  private String desc;
  /**
   * 评论星级：1-5星
   */
  private long cGrade;
  /**
   * 审核：1 通过展示 0 不通过隐藏
   */
  private long isDelete;
  /**
   * 评论时间
   */
  private Date createTime;
  /**
   * 修改时间（一般不会更改）
   */
  private Date updateTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }


  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }


  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }


  public long getCGrade() {
    return cGrade;
  }

  public void setCGrade(long cGrade) {
    this.cGrade = cGrade;
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
