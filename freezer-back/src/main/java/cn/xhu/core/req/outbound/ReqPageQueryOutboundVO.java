package cn.xhu.core.req.outbound;

/**
 *@author:zx
 *@create time:2021/2/16 20:26
 *@desciption:
 *
 */

public class ReqPageQueryOutboundVO {
    private String customerName;
    private String customerTel;
    private Integer status;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
