package cn.xhu.biz.service.impl;

import cn.xhu.biz.dao.UserDao;
import cn.xhu.biz.service.UserService;
import cn.xhu.common.utils.CollectionUtils;
import cn.xhu.converter.UserConverter;
import cn.xhu.core.pojo.User;
import cn.xhu.core.req.LoginRequestVO;
import cn.xhu.core.req.user.ChangePasswordReqVO;
import cn.xhu.core.req.user.ReqPageQueryUserVO;
import cn.xhu.core.req.user.ReqUserVO;
import cn.xhu.core.req.user.SaveUserReqVO;
import cn.xhu.core.resp.RespUserVO;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;


/**
 * @author:zx
 * @create time:2021/1/31
 * @desciption:
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private UserConverter userConverter;


    @Override
    public RespUserVO queryUserByCondition(LoginRequestVO req) {
        RespUserVO respUserVO=new RespUserVO();
        User user = userDao.queryByCondition(req);
        if (cn.xhu.common.utils.BeanUtils.isNotEmpty(user)) {
            BeanUtils.copyProperties(user, respUserVO);
        }
        return respUserVO;
    }

    @Override
    public PageInfo<RespUserVO> queryPageUsers(ReqPageQueryUserVO req){
        List<User> users = userDao.queryPageUsers(req);
        PageInfo<RespUserVO> pageInfo=null;
        try {
            if (CollectionUtils.isNotEmpty(users)) {
                pageInfo = new PageInfo<>();
                pageInfo.setList(userConverter.d2vs(users));
                pageInfo.setPageSize(users.size());
            }
        }catch (Exception e){
            throw new SQLException("查询出错");
        }finally {
            return pageInfo;
        }
    }

    @Override
    public void changePassword(ChangePasswordReqVO req) {
        ReqUserVO reqUserVO=new ReqUserVO();
        try {
            reqUserVO.setId(req.getId());
            reqUserVO.setPassword(req.getNewPassword());
            userDao.update(reqUserVO);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public Long saveUser(ReqUserVO req) throws SQLException {
        Long result=null;
        try {
            //新增
            if (req.getId() == null) {
                result = userDao.insert(req);
            }
            //修改
            else {
                result = userDao.update(req);
            }
        }catch (Exception e){
            throw new SQLException("保存员工信息失败");
        }finally {
            return result;
        }
    }

    @Override
    public void deleteUser(Long id) throws SQLException {
        try {
            userDao.delete(id);
        }catch (Exception e){
            throw new SQLException("删除失败");
        }
    }

    @Override
    public void deleteAllUserRoles(Long id) throws SQLException {
        try{
            userDao.deleteUserRoleByUserId(id);
        }catch (Exception e){
            throw new SQLException("删除员工关联的角色失败");
        }

    }
}
