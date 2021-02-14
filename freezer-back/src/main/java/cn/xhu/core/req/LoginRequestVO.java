package cn.xhu.core.req;

/**
 * @author:zx
 * @create time:2021/2/13 12:18
 * @desciption:登录请求参数
 */


public class LoginRequestVO {
    /**
     * 员工账号（用户名）
     */
    private String userName;
    /**
     * 密码
     */
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
