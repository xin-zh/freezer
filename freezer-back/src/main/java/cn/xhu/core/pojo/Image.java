package cn.xhu.core.pojo;
/**
 * 商品图片信息
 */

import java.sql.Date;

public class Image {

  /**
   * 主键ID
   */
  private long id;
  /**
   * 代销商品批次号
   */
  private String productNo;
  /**
   * 图片URL
   */
  private String imageUrl;
  /**
   * 图片描述
   */
  private String imageDesc;
  /**
   * 是否删除：0未删除 1删除
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


  public String getProductNo() {
    return productNo;
  }

  public void setProductNo(String productNo) {
    this.productNo = productNo;
  }


  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }


  public String getImageDesc() {
    return imageDesc;
  }

  public void setImageDesc(String imageDesc) {
    this.imageDesc = imageDesc;
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
