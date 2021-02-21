package cn.xhu.core.req.customer;

/**
 *@author:zx
 *@create time:2021/2/20 21:19
 *@desciption:
 *
 */

public class ReqCustomerVO {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 用户名（账号）
     */
    private String customerName;
    /**
     * 顾客真实姓名（果农或水果商 存在交易的需要实名验证）
     */
    private String realName;
    /**
     * 用户密码
     */
    private String customerPsw;
    /**
     * 用户性别：1男 2女 3保密
     */
    private long sex;
    /**
     * 年龄，最小为0 最大为150
     */
    private long age;
    /**
     * 身份证号（若要办理入库需要身份认证）
     */
    private String identify;
    /**
     * 用户联系方式
     */
    private String customerTel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCustomerPsw() {
        return customerPsw;
    }

    public void setCustomerPsw(String customerPsw) {
        this.customerPsw = customerPsw;
    }

    public long getSex() {
        return sex;
    }

    public void setSex(long sex) {
        this.sex = sex;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }
}
