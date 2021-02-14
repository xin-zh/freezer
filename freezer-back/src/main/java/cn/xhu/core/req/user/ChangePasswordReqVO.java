package cn.xhu.core.req.user;

/**
 * @author:zx
 * @create time:2021/2/14 12:51
 * @desciption:
 */


public class ChangePasswordReqVO {
    private Long id;
    private String oldPassword;
    private String newPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
