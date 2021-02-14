package cn.xhu.core.pojo;

import java.sql.Date;

/**
 * 入库水果信息子表
 */
public class InboundItemInfo {
  /**
   * 主键ID
   */
  private long id;
  /**
   * 入库编号
   */
  private String inboundNo;
  /**
   * item项名称
   */
  private String itemName;
  /**
   * 入库数量
   */
  private long inboundNum;
  /**
   * 库存量
   */
  private long inventory;
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


  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }


  public long getInboundNum() {
    return inboundNum;
  }

  public void setInboundNum(long inboundNum) {
    this.inboundNum = inboundNum;
  }


  public long getInventory() {
    return inventory;
  }

  public void setInventory(long inventory) {
    this.inventory = inventory;
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
