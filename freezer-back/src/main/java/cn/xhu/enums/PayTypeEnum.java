package cn.xhu.enums;

/**
 * @author:zx
 * @create time:2021/2/13 15:18
 * @desciption:支付类型枚举
 */


public enum PayTypeEnum {
    WECHAT(1, "微信支付"),
    ALIPAY(2, "支付宝");
    private Integer code;
    private String desc;

    PayTypeEnum(Integer code, String desc) {
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
