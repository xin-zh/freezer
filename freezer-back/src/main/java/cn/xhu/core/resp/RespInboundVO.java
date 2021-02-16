package cn.xhu.core.resp;

import cn.xhu.core.pojo.InboundItemInfo;

import java.util.Date;
import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/16 17:19
 *@desciption:
 *
 */

public class RespInboundVO {
    private     Long                  id;
    private     String                inboundNo;
    private     String                customerName;
    private     Double                actualPay;
    private     Double                shouldPay;
    private     String                operator;
    private     Date                  createTime;
    private     Date                  updateTime;
    //入库单的子项
        private List<InboundItemInfo> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Double getActualPay() {
        return actualPay;
    }

    public void setActualPay(Double actualPay) {
        this.actualPay = actualPay;
    }

    public Double getShouldPay() {
        return shouldPay;
    }

    public void setShouldPay(Double shouldPay) {
        this.shouldPay = shouldPay;
    }

    public List<InboundItemInfo> getItems() {
        return items;
    }

    public void setItems(List<InboundItemInfo> items) {
        this.items = items;
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
