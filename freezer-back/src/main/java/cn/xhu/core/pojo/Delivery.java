package cn.xhu.core.pojo;

import java.sql.Date;

/**
 * 评论表
 */
public class Delivery {

  /**
   * 主键ID
   */
  private long id;
  /**
   * 订单序列号
   */
  private String orderNo;
  /**
   * 物流编号
   */
  private String expressNo;
  /**
   * 物流公司名
   */
  private String expressName;
  /**
   * 发件人姓名
   */
  private String sender;
  /**
   * 发件人地址
   */
  private String senderAddress;
  /**
   * 发件人联系方式
   */
  private String senderTel;
  /**
   * 收件人姓名
   */
  private String receiver;
  /**
   * 收件人地址
   */
  private String receiverAddress;
  /**
   * 收件人联系方式
   */
  private String receiverTel;
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


  public String getExpressNo() {
    return expressNo;
  }

  public void setExpressNo(String expressNo) {
    this.expressNo = expressNo;
  }


  public String getExpressName() {
    return expressName;
  }

  public void setExpressName(String expressName) {
    this.expressName = expressName;
  }


  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }


  public String getSenderAddress() {
    return senderAddress;
  }

  public void setSenderAddress(String senderAddress) {
    this.senderAddress = senderAddress;
  }


  public String getSenderTel() {
    return senderTel;
  }

  public void setSenderTel(String senderTel) {
    this.senderTel = senderTel;
  }


  public String getReceiver() {
    return receiver;
  }

  public void setReceiver(String receiver) {
    this.receiver = receiver;
  }


  public String getReceiverAddress() {
    return receiverAddress;
  }

  public void setReceiverAddress(String receiverAddress) {
    this.receiverAddress = receiverAddress;
  }


  public String getReceiverTel() {
    return receiverTel;
  }

  public void setReceiverTel(String receiverTel) {
    this.receiverTel = receiverTel;
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
