package cn.xhu.core.req.user;

import cn.xhu.core.req.PageQuery;

/**
 * @author:zx
 * @create time:2021/2/12 20:53
 * @desciption:
 */


public class ReqPageQueryUserVO extends PageQuery {
    /**
     * 员工账号（用户名）
     */
    private String userName;
    /**
     * 员工真实姓名
     */
    private String realName;
    /**
     * 联系方式
     */
    private String userTel;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }
}
