package cn.xhu.converter;

import cn.xhu.core.pojo.Customer;
import cn.xhu.core.req.customer.ReqCustomerVO;
import cn.xhu.core.resp.RespCustomerVO;

import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/20 21:40
 *@desciption:
 *
 */

public interface CustomerConverter {
    Customer v2d(RespCustomerVO v);

    Customer v2d(ReqCustomerVO v);

    RespCustomerVO d2v(Customer d);

    List<RespCustomerVO> d2vs(List<Customer> d);

    List<Customer> v2ds(List<RespCustomerVO> v);
}
