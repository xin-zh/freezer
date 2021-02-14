package cn.xhu.core.pojo;

import java.sql.Date;

/**
 * 订单信息主表信息
 */
public class SellOrder {
  /**
   * 主键ID
   */
  private long id;
  /**
   * 订单序列号
   */
  private String orderNo;
  /**
   * 用户序列号
   */
  private String customerName;
  /**
   * 支付类型：1支付宝 2微信
   */
  private long payType;
  /**
   * 支付金额
   */
  private double payMoney;
  /**
   * 支付时间
   */
  private Date payTime;
  /**
   * 收货时间
   */
  private Date receiveTime;
  /**
   * 订单状态：0已取消 1待付款 2待发货 3待收货 4交易成功 5交易超时
   */
  private long status;
  /**
   * 是否删除：1删除 0未删除
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


  public long getPayType() {
    return payType;
  }

  public void setPayType(long payType) {
    this.payType = payType;
  }


  public double getPayMoney() {
    return payMoney;
  }

  public void setPayMoney(double payMoney) {
    this.payMoney = payMoney;
  }


  public Date getPayTime() {
    return payTime;
  }

  public void setPayTime(Date payTime) {
    this.payTime = payTime;
  }


  public Date getReceiveTime() {
    return receiveTime;
  }

  public void setReceiveTime(Date receiveTime) {
    this.receiveTime = receiveTime;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
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
