package cn.xhu.converter;

import cn.xhu.core.pojo.Menu;
import cn.xhu.core.req.menu.ReqMenuVO;
import cn.xhu.core.resp.RespMenuVO;

import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/14 19:25
 *@desciption:
 *
 */

public interface MenuConverter {
    Menu v2d(RespMenuVO v);

    Menu v2d(ReqMenuVO v);

    RespMenuVO d2v(Menu d);

    List<RespMenuVO> d2vs(List<Menu> d);

    List<Menu> v2ds(List<RespMenuVO> v);
}
