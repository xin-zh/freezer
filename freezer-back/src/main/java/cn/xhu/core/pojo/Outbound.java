package cn.xhu.core.pojo;

import java.sql.Date;

public class Outbound {
  /**
   * 主键ID
   */
  private long id;
  /**
   * 出库序列号
   */
  private String outboundNo;
  /**
   * 用户序列号
   */
  private String customerName;

  /**
   * 用户联系方式
   */
  private String customerTel;
  /**
   * 出库状态：0已预约 1已受理 2已出库
   */
  private long status;

  /**
   * 是否邮寄：0否 1是
   */
  private long   isMail;
  /**
   * 处理人员（员工userName）
   */
  private String operator;
  /***
   * 出库时间
   */
  private Date   createTime;
  /**
   * 更新时间
   */
  private Date   updateTime;
  /**
   * 扩展信息
   */
  private String extInfo;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getOutboundNo() {
    return outboundNo;
  }

  public void setOutboundNo(String outboundNo) {
    this.outboundNo = outboundNo;
  }


  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }


  public String getCustomerTel() {
    return customerTel;
  }

  public void setCustomerTel(String customerTel) {
    this.customerTel = customerTel;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getExtInfo() {
    return extInfo;
  }

  public void setExtInfo(String extInfo) {
    this.extInfo = extInfo;
  }


  public long getIsMail() {
    return isMail;
  }

  public void setIsMail(long isMail) {
    this.isMail = isMail;
  }


  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
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
