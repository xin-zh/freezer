package cn.xhu.converter.impl;

import cn.xhu.converter.UserConverter;
import cn.xhu.core.pojo.User;
import cn.xhu.core.req.user.ReqUserVO;
import cn.xhu.core.resp.RespUserVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:zx
 * @create time:2021/2/14 13:35
 * @desciption:
 */

@Service
public class UserConverterImpl extends BaseConverter implements UserConverter {
    @Override
    public User v2d(RespUserVO v) {
        User target=new User();
        return (User) converter(v,target.getClass());
    }

    @Override
    public User v2d(ReqUserVO v) {
        User target=new User();
        return (User) converter(v,target.getClass());
    }

    @Override
    public RespUserVO d2v(User d) {
        RespUserVO target = new RespUserVO();
        return (RespUserVO) converter(d,target.getClass());
    }

    @Override
    public List<RespUserVO> d2vs(List<User> d) {
        RespUserVO target=null;
        List<RespUserVO> list=new ArrayList<>();
        for (User user:d){
            target=new RespUserVO();
            RespUserVO respUserVO = (RespUserVO) converter(user, target.getClass());
            list.add(respUserVO);
        }
        return list;
    }

    @Override
    public List<User> v2ds(List<RespUserVO> v) {
        User target=null;
        List<User> list=new ArrayList<>();
        for (RespUserVO respUserVO:v){
            target=new User();
            User user = (User) converter(respUserVO, target.getClass());
            list.add(user);
        }
        return list;
    }
}
