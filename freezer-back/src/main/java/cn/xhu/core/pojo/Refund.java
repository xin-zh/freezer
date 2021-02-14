package cn.xhu.core.pojo;

import java.sql.Date;

/**
 * 退款信息
 */
public class Refund {
  /**
   * 主键ID
   */
  private long id;
  /**
   * 用户序列号
   */
  private String customerName;
  /**
   * 订单序列号
   */
  private String orderNo;
  /**
   *退款原因
   */
  private String refundReason;
  /**
   * 退款到账时间
   */
  private Date refundTime;
  /**
   * 退款状态：1已受理 0未受理
   */
  private long status;
  /**
   * 退款发起时间
   */
  private Date createTime;
  /**
   * 退款处理时间
   */
  private Date updateTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }


  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }


  public String getRefundReason() {
    return refundReason;
  }

  public void setRefundReason(String refundReason) {
    this.refundReason = refundReason;
  }


  public Date getRefundTime() {
    return refundTime;
  }

  public void setRefundTime(Date refundTime) {
    this.refundTime = refundTime;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
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
