package cn.xhu.core.req.outbound;

import cn.xhu.core.pojo.OutboundItemInfo;

import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/16 20:25
 *@desciption:
 *
 */

public class SaveOutBoundReqVO {
    private Long id;
    private String outboundNo;
    private String customerName;
    private Integer status;
    private Integer isMail;
    private String operator;
    //扩展信息
    private String extInfo;
    private List<OutboundItemInfo> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsMail() {
        return isMail;
    }

    public void setIsMail(Integer isMail) {
        this.isMail = isMail;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public List<OutboundItemInfo> getItems() {
        return items;
    }

    public void setItems(List<OutboundItemInfo> items) {
        this.items = items;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }
}
