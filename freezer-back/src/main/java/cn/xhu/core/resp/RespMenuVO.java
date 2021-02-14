package cn.xhu.core.resp;

import java.sql.Date;

/**
 * @author:zx
 * @create time:2021/2/12 21:09
 * @desciption:
 */


public class RespMenuVO {
    private long   id;
    private   long   parentId;
    private   String menuName;
    private   String url;
    private   String perms;
    private   long   menuType;
    private   long   orderNum;
    private   String remark;
    private   String routerName;
    private   String routerPath;

    @Override public String toString() {
        return "RespMenuVO{" + "id=" + id + ", parentId=" + parentId + ", menuName='" + menuName + '\'' + ", url='" + url + '\'' + ", perms='" + perms + '\'' + ", menuType="
               + menuType + ", orderNum=" + orderNum + ", remark='" + remark + '\'' + ", routerName='" + routerName + '\'' + ", routerPath='" + routerPath + '\'' + '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public long getMenuType() {
        return menuType;
    }

    public void setMenuType(long menuType) {
        this.menuType = menuType;
    }

    public long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(long orderNum) {
        this.orderNum = orderNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRouterName() {
        return routerName;
    }

    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public String getRouterPath() {
        return routerPath;
    }

    public void setRouterPath(String routerPath) {
        this.routerPath = routerPath;
    }
}
