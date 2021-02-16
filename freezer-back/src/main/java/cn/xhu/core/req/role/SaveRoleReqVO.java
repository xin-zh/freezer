package cn.xhu.core.req.role;

import java.util.List;

/**
 * @author:zx
 * @create time:2021/2/12 21:03
 * @desciption:
 */


public class SaveRoleReqVO {
    private Long id;
    private String roleName;
    private List<Long> menuIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Long> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Long> menuIds) {
        this.menuIds = menuIds;
    }
}

