package cn.xhu.core.pojo;

import java.sql.Date;

/**
 * 入库信息
 */
public class Inbound {
  /**
   * 主键ID
   */
  private long id;
  /**
   * 入库序列号
   */
  private String inboundNo;
  /**
   * 用户名
   */
  private String customerName;
  /**
   * 处理人员（员工姓名userName）
   */
  private String operator;
  /**
   * 入库状态：0已预约 1已受理 2库存中 3全出库
   */
  private long status;
  /**
   * 实付款
   */
  private double actualPay;
  /**
   * 应付款
   */
  private double shouldPay;
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


  public String getInboundNo() {
    return inboundNo;
  }

  public void setInboundNo(String inboundNo) {
    this.inboundNo = inboundNo;
  }


  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }


  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public double getActualPay() {
    return actualPay;
  }

  public void setActualPay(double actualPay) {
    this.actualPay = actualPay;
  }


  public double getShouldPay() {
    return shouldPay;
  }

  public void setShouldPay(double shouldPay) {
    this.shouldPay = shouldPay;
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
