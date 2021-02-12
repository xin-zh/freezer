package cn.xhu.biz.service.impl;

import cn.xhu.biz.dao.UserDao;
import cn.xhu.biz.service.UserService;
import cn.xhu.common.PasswordHelper;
import cn.xhu.core.pojo.User;
import cn.xhu.core.req.user.ReqPageQueryUserVO;
import cn.xhu.core.req.user.ReqUserVO;
import cn.xhu.core.req.user.SaveUserReqVO;
import cn.xhu.core.resp.RespUserVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:zx
 * @create time:2021/1/31
 * @desciption:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;


    @Override
    public RespUserVO queryUserByCondition(ReqUserVO req) {
        User user = userDao.queryByCondition(req);
        RespUserVO respUserVO=new RespUserVO();
        if (cn.xhu.common.utils.BeanUtils.isNotEmpty(user)) {
            BeanUtils.copyProperties(user, respUserVO);
        }
        return respUserVO;
    }

    @Override
    public PageInfo<RespUserVO> queryPageUsers(ReqPageQueryUserVO req) throws Exception {
        return null;
    }

    @Override
    public void changePassword(Long userId, String newPassword) {

    }

    @Override
    public int saveUser(SaveUserReqVO req) throws Exception {
        return 0;
    }

    @Override
    public int deleteUser(Long id) throws Exception {
        return 0;
    }

    @Override
    public void deleteAllUserRoles(Long id) {

    }
}
