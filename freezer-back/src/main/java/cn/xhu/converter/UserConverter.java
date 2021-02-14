package cn.xhu.converter;

import cn.xhu.core.pojo.User;
import cn.xhu.core.req.user.ReqUserVO;
import cn.xhu.core.resp.RespUserVO;

import java.util.List;

/**
 * @author:zx
 * @create time:2021/2/14 12:38
 * @desciption:
 */


public interface UserConverter {
    User v2d(RespUserVO v);

    User v2d(ReqUserVO v);

    RespUserVO d2v(User d);

    List<RespUserVO> d2vs(List<User> d);

    List<User> v2ds(List<RespUserVO> v);
}
