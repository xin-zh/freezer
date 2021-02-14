package cn.xhu.core.pojo;

import java.sql.Date;

/**
 * 购物车信息
 */
public class Shopcart {
  /**
   * 主键ID
   */
  private long id;
  /**
   * 用户序列号
   */
  private String customerName;
  /**
   * 代销商品批次号
   */
  private String productNo;
  /**
   * 代销商品名称
   */
  private String productName;
  /**
   * 代销商品单价
   */
  private double unitPrice;
  /**
   * 加购商品数量
   */
  private long cnt;
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


  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
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


  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }


  public long getCnt() {
    return cnt;
  }

  public void setCnt(long cnt) {
    this.cnt = cnt;
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
