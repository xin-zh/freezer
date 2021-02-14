package cn.xhu.core.pojo;

import java.sql.Date;

/**
 * 代销商品信息
 */
public class Product {
  /**
   * 主键ID
   */
  private long id;
  /**
   * 代销商品批次号
   */
  private String productNo;
  /**
   * 代销商品名称
   */
  private String productName;
  /**
   * 代销商品描述
   */
  private String productDesc;
  /**
   * 代销商品库存量
   */
  private long inventory;
  /**
   * 代销商品单价
   */
  private double unitPrice;
  /**
   * 状态：1上架 0下架
   */
  private long status;
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


  public String getProductDesc() {
    return productDesc;
  }

  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }


  public long getInventory() {
    return inventory;
  }

  public void setInventory(long inventory) {
    this.inventory = inventory;
  }


  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
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
