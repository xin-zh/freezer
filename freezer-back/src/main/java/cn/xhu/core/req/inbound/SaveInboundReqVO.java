package cn.xhu.core.req.inbound;

import cn.xhu.core.pojo.InboundItemInfo;

import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/16 17:18
 *@desciption:
 *
 */

public class SaveInboundReqVO {
    private     Long                  id;
    private     String                inboundNo;
    private     String                customerName;
    private     Double                actualPay;
    private     Double                shouldPay;
    private String extInfo;
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

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }
}
