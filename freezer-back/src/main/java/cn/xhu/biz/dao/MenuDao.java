package cn.xhu.biz.dao;

import cn.xhu.core.pojo.Menu;
import cn.xhu.core.req.menu.ReqMenuVO;
import cn.xhu.core.req.menu.ReqPageQueryMenuVO;
import cn.xhu.core.req.role.ReqPageQueryRoleVO;
import cn.xhu.core.req.role.ReqRoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author:zx
 * @create time:2021/2/13 16:02
 * @desciption:
 */


public interface MenuDao {
    Long insert(ReqMenuVO reqMenu);

    Long delete(@Param("id") Long id);

    Long update(ReqMenuVO reqMenu);

    List<Menu> queryPageMenus(ReqPageQueryMenuVO req);

    Menu queryById(@Param("id") Long id);
}
