package cn.xhu.biz.service.impl;

import cn.xhu.biz.dao.MenuDao;
import cn.xhu.biz.dao.RoleDao;
import cn.xhu.biz.service.MenuService;
import cn.xhu.common.utils.CollectionUtils;
import cn.xhu.converter.MenuConverter;
import cn.xhu.core.pojo.Menu;
import cn.xhu.core.pojo.Role;
import cn.xhu.core.req.menu.ReqMenuVO;
import cn.xhu.core.req.menu.ReqPageQueryMenuVO;
import cn.xhu.core.req.menu.SaveMenuReqVO;
import cn.xhu.core.req.role.ReqRoleMenuVO;
import cn.xhu.core.resp.RespMenuVO;
import cn.xhu.core.resp.RespRoleVO;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:zx
 * @create time:2021/2/12 22:26
 * @desciption:
 */

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDao menuDao;

    @Resource
    private RoleDao       roleDao;
    @Resource
    private MenuConverter menuConverter;

    @Override
    public RespMenuVO queryById(Long id) {
        return menuConverter.d2v(menuDao.queryById(id));
    }

    @Override
    public PageInfo<RespMenuVO> queryPageMenus(ReqPageQueryMenuVO req) {
        List<Menu> menus = menuDao.queryPageMenus(req);
        PageInfo<RespMenuVO> pageInfo=null;
        try{
            if(CollectionUtils.isNotEmpty(menus)){
                pageInfo=new PageInfo<>();
                pageInfo.setList(menuConverter.d2vs(menus));
            }
        }catch (Exception e){
            throw new SQLException("查询异常");
        }finally {
            return pageInfo;
        }
    }

    @Override
    public Long saveMenu(ReqMenuVO req) {
        Long result=null;
        try {
            //新增
            if (req.getId() == null) {
                result = menuDao.insert(req);
            }
            //修改
            else {
                result = menuDao.update(req);
            }
        }catch (Exception e){
            throw new SQLException("保存员工信息失败");
        }finally {
            return result;
        }
    }

    @Override
    public void deleteMenu(Long id) {
        menuDao.delete(id);

    }

    @Override
    public List<Menu> queryRoleMenus(ReqRoleMenuVO req) {
        List<Menu> menuList=new ArrayList<>();
        for (Role role:req.getRoles()){
            menuList.addAll(roleDao.queryMenusByRoleId(role.getId()));
        }
        return menuList;
    }
}
