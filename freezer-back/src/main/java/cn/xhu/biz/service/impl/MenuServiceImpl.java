package cn.xhu.biz.service.impl;

import cn.xhu.biz.service.MenuService;
import cn.xhu.core.pojo.Menu;
import cn.xhu.core.req.menu.ReqMenuVO;
import cn.xhu.core.req.menu.ReqPageQueryMenuVO;
import cn.xhu.core.req.menu.SaveMenuReqVO;
import cn.xhu.core.req.role.ReqRoleMenuVO;
import cn.xhu.core.resp.RespMenuVO;
import cn.xhu.core.resp.RespRoleVO;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:zx
 * @create time:2021/2/12 22:26
 * @desciption:
 */

@Service
public class MenuServiceImpl implements MenuService {
    @Override
    public List<RespMenuVO> getPermissionByUser(Long id) {
        return null;
    }

    @Override
    public RespRoleVO queryMenuByExample(ReqMenuVO req) {
        return null;
    }

    @Override
    public PageInfo<RespMenuVO> queryPageMenus(ReqPageQueryMenuVO req) {
        return null;
    }

    @Override
    public int saveMenu(SaveMenuReqVO req) {
        return 0;
    }

    @Override
    public int deleteMenu(Long id) {
        return 0;
    }

    @Override
    public List<Menu> queryRoleMenus(ReqRoleMenuVO req) {
        return null;
    }
}
