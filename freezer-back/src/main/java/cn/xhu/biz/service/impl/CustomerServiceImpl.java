package cn.xhu.biz.service.impl;

import cn.xhu.biz.dao.CustomerDao;
import cn.xhu.biz.service.CustomerService;
import cn.xhu.common.utils.CollectionUtils;
import cn.xhu.converter.CustomerConverter;
import cn.xhu.core.pojo.Customer;
import cn.xhu.core.req.LoginRequestVO;
import cn.xhu.core.req.customer.ReqCustomerVO;
import cn.xhu.core.req.customer.ReqPageQueryCustomerVO;
import cn.xhu.core.req.user.ChangePasswordReqVO;
import cn.xhu.core.resp.RespCustomerVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/20 21:38
 *@desciption:
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao       customerDao;
    @Resource
    private CustomerConverter customerConverter;

    @Override public RespCustomerVO queryCustomerByCondition(LoginRequestVO req) {
        RespCustomerVO respCustomerVO=new RespCustomerVO();
        Customer customer = customerDao.queryByCondition(req);
        if (cn.xhu.common.utils.BeanUtils.isNotEmpty(customer)) {
            BeanUtils.copyProperties(customer, respCustomerVO);
        }
        return respCustomerVO;
    }

    @Override public PageInfo<RespCustomerVO> queryPageCustomers(ReqPageQueryCustomerVO req) {
        List<Customer> customers = customerDao.queryPageCustomers(req);
        PageInfo<RespCustomerVO> pageInfo=null;
        try {
            if (CollectionUtils.isNotEmpty(customers)) {
                pageInfo = new PageInfo<>();
                pageInfo.setList(customerConverter.d2vs(customers));
                pageInfo.setPageSize(customers.size());
            }
        }catch (Exception e){
            throw new SQLException("查询出错");
        }finally {
            return pageInfo;
        }
    }

    @Override
    public void changePassword(ChangePasswordReqVO req) {

    }

    @Override public Long saveCustomer(ReqCustomerVO req) throws Exception {
        Long result=null;
        try {
            //新增
            if (req.getId() == null) {
                result = customerDao.insert(req);
            }
            //修改
            else {
                result = customerDao.update(req);
            }
        }catch (Exception e){
            throw new SQLException("保存信息失败");
        }finally {
            return result;
        }
    }

    @Override public void deleteCustomer(Long id) throws Exception {
        customerDao.delete(id);
    }
}
