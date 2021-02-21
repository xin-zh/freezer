package cn.xhu.biz.service;

import cn.xhu.core.req.LoginRequestVO;
import cn.xhu.core.req.customer.ReqCustomerVO;
import cn.xhu.core.req.customer.ReqPageQueryCustomerVO;
import cn.xhu.core.req.user.ChangePasswordReqVO;
import cn.xhu.core.resp.RespCustomerVO;
import com.github.pagehelper.PageInfo;

/**
 *@author:zx
 *@create time:2021/2/20 21:36
 *@desciption:
 *
 */

public interface CustomerService {
    /**
     * 根据条件查询用户
     * @param req
     * @return
     */
    RespCustomerVO queryCustomerByCondition(LoginRequestVO req);

    /**
     * 分页查询
     * @param req
     * @return
     * @throws Exception
     */
    PageInfo<RespCustomerVO> queryPageCustomers(ReqPageQueryCustomerVO req);

    /**
     * 修改密码
     *
     */
    void changePassword(ChangePasswordReqVO req);

    /**
     * 保存员工信息
     * @param req
     * @return
     * @throws Exception
     */
    Long saveCustomer(ReqCustomerVO req) throws Exception;

    /**
     * 删除员工信息
     * @param id
     * @return
     * @throws Exception
     */
    void deleteCustomer(Long id) throws Exception;
}
