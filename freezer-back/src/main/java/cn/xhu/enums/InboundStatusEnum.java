package cn.xhu.enums;

/**
 * @author:zx
 * @create time:2021/2/13 15:27
 * @desciption:入库状态枚举
 */


public enum InboundStatusEnum {
    APPOINTMENT(0,"已预约"),
    ACCEPTED(1,"已受理"),
    IN_STOCK(2,"库存中"),
    FULL_OUTBOUND(3,"全出库");

    private Integer code;
    private String desc;

    InboundStatusEnum(Integer code, String desc) {
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
