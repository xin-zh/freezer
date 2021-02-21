package cn.xhu.core.req.customer;

/**
 *@author:zx
 *@create time:2021/2/20 21:17
 *@desciption:
 *
 */

public class ReqPageQueryCustomerVO {
    /**
     * 客户用户名（相当于账号）
     */
    private String customerName;
    /**
     * 客户真实姓名
     */
    private String realName;
    /**
     * 客户联系方式
     */
    private String customerTel;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }
}
