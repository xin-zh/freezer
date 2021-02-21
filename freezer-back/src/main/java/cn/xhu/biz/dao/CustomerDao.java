package cn.xhu.biz.dao;

import cn.xhu.core.pojo.Customer;
import cn.xhu.core.req.LoginRequestVO;
import cn.xhu.core.req.customer.ReqCustomerVO;
import cn.xhu.core.req.customer.ReqPageQueryCustomerVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/20 21:23
 *@desciption:
 *
 */

public interface CustomerDao {

    /**
     * 新增客户信息
     * @param reqCustomer
     * @return
     */
    Long insert(ReqCustomerVO reqCustomer);

    /**
     * 删除员工信息,理论上不是用到
     * @param id
     */
    void delete(@Param("id") Long id);
    /**
     * 修改客户信息
     * @param customer
     * @return
     */
    Long update(ReqCustomerVO customer);

    /**
     * 分页查询
     * @param req
     * @return
     */
    List<Customer> queryPageCustomers(ReqPageQueryCustomerVO req);

    /**
     * 查询所有员工记录条数
     * @param req
     * @return
     */
    Integer queryAllCustomers(ReqPageQueryCustomerVO req);

    /**
     * 登录时的查询操作
     * @param reqCustomer
     * @return
     */
    Customer queryByCondition(LoginRequestVO reqCustomer);

    /**
     * 根据ID查询客户信息
     * @param id
     * @return
     */
    Customer queryById(Long id);
}
