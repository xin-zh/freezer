package cn.xhu.converter.impl;

import cn.xhu.converter.MenuConverter;
import cn.xhu.core.pojo.Menu;
import cn.xhu.core.req.menu.ReqMenuVO;
import cn.xhu.core.resp.RespMenuVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/14 19:56
 *@desciption:
 *
 */
@Service
public class MenuConverterImpl  extends BaseConverter implements MenuConverter{
    @Override
    public Menu v2d(RespMenuVO v) {
        Menu target=new Menu();
        return (Menu) converter(v,target.getClass());
    }

    @Override public Menu v2d(ReqMenuVO v) {
        Menu target=new Menu();
        return (Menu) converter(v,target.getClass());
    }

    @Override public RespMenuVO d2v(Menu d) {
        RespMenuVO target=new RespMenuVO();
        return (RespMenuVO) converter(d,target.getClass());
    }

    @Override public List<RespMenuVO> d2vs(List<Menu> d) {
        RespMenuVO target=null;
        List<RespMenuVO> list=new ArrayList<>();
        for (Menu menu:d){
            target=new RespMenuVO();
            RespMenuVO respMenuVO = (RespMenuVO) converter(menu, target.getClass());
            list.add(respMenuVO);
        }
        return list;
    }

    @Override public List<Menu> v2ds(List<RespMenuVO> v) {
        Menu target=null;
        List<Menu> list=new ArrayList<>();
        for (RespMenuVO respMenuVO:v){
            target=new Menu();
            Menu menu = (Menu) converter(respMenuVO, target.getClass());
            list.add(menu);
        }
        return list;
    }
}
