package cn.xhu.enums;

/**
 * @author:zx
 * @create time:2021/2/13 15:22
 * @desciption:订单状态枚举
 */


public enum OrderStatusEnum {
    CANCEL(0,"已取消"),
    WAITING_PAYMENT(1,"待付款"),
    WAITING_DELIVERY(2,"待发货"),
    WAITING_RECEIPT(3,"待收货"),
    TRADE_SUCCESS(4,"交易成功"),
    TRADE_OVERTIME(5,"交易超时");

    private Integer code;
    private String desc;

    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }}
