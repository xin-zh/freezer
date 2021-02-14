package cn.xhu.core.pojo;

import java.sql.Date;

/**
 * 出库信息子项
 */
public class OutboundItemInfo {
  /**
   * 主键ID
   */
  private long id;
  /**
   * 出库编号
   */
  private String outboundNo;
  /**
   * 出库项名称
   */
  private String itemName;
  /**
   * 出库数量
   */
  private long outboundNum;
  /**
   * 出库时间
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


  public String getOutboundNo() {
    return outboundNo;
  }

  public void setOutboundNo(String outboundNo) {
    this.outboundNo = outboundNo;
  }


  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }


  public long getOutboundNum() {
    return outboundNum;
  }

  public void setOutboundNum(long outboundNum) {
    this.outboundNum = outboundNum;
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
