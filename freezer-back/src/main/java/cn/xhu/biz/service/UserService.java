package cn.xhu.biz.service;

import cn.xhu.core.pojo.User;
import cn.xhu.core.req.user.ReqPageQueryUserVO;
import cn.xhu.core.req.user.ReqUserVO;
import cn.xhu.core.req.user.SaveUserReqVO;
import cn.xhu.core.resp.RespUserVO;
import com.github.pagehelper.PageInfo;

/**
 * @author:zx
 * @create time:2021/1/31
 * @desciption:
 */
public interface UserService  {

    /**
     * 根据条件查询用户
     * @param req
     * @return
     */
    RespUserVO queryUserByCondition(ReqUserVO req);

    /**
     * 分页查询
     * @param req
     * @return
     * @throws Exception
     */
    PageInfo<RespUserVO> queryPageUsers(ReqPageQueryUserVO req) throws Exception;

    /**
     * 修改密码
     *
     * @param userId
     * @param newPassword
     */
    void changePassword(Long userId, String newPassword);

    /**
     * 保存员工信息
     * @param req
     * @return
     * @throws Exception
     */
    int saveUser(SaveUserReqVO req) throws Exception;

    /**
     * 删除员工信息
     * @param id
     * @return
     * @throws Exception
     */
    int deleteUser(Long id) throws Exception;

    /**
     * 删除此用户关联的所有角色信息
     * @param id
     */
    void deleteAllUserRoles(Long id);
}
