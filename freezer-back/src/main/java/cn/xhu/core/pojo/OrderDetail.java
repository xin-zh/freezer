package cn.xhu.core.pojo;

import java.sql.Date;

/**
 * 订单详细信息
 */
public class OrderDetail {
  /**
   * 主键ID
   */
  private long id;
  /**
   * 订单序列号
   */
  private String orderNo;
  /**
   * 商品序列号
   */
  private String productNo;
  /**
   * 商品名称
   */
  private String productName;
  /**
   * 购买商品数量
   */
  private long productCnt;
  /**
   * 商品单价
   */
  private double unitPrice;
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


  public String getProductNo() {
    return productNo;
  }

  public void setProductNo(String productNo) {
    this.productNo = productNo;
  }


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }


  public long getProductCnt() {
    return productCnt;
  }

  public void setProductCnt(long productCnt) {
    this.productCnt = productCnt;
  }


  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
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
