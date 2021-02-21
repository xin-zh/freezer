package cn.xhu.core.resp;

import cn.xhu.core.pojo.Menu;

import java.util.List;

/**
 * @author:zx
 * @create time:2021/2/12 20:48
 * @desciption:
 */


public class RespRoleVO {
    /**
     * 主键ID
     */
    private long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 操作人员
     */
    private String operator;

    private List<Menu> menuList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
