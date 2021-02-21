package cn.xhu.converter.impl;

import cn.xhu.converter.CustomerConverter;
import cn.xhu.core.pojo.Customer;
import cn.xhu.core.pojo.Customer;
import cn.xhu.core.pojo.Customer;
import cn.xhu.core.pojo.Customer;
import cn.xhu.core.req.customer.ReqCustomerVO;
import cn.xhu.core.resp.RespCustomerVO;
import cn.xhu.core.resp.RespCustomerVO;
import cn.xhu.core.resp.RespCustomerVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/20 21:41
 *@desciption:
 *
 */
@Service
public class CustomerConverterImpl extends BaseConverter implements CustomerConverter {
    @Override public Customer v2d(RespCustomerVO v) {
        Customer target=new Customer();
        return (Customer) converter(v,target.getClass());
    }

    @Override public Customer v2d(ReqCustomerVO v) {
        Customer target=new Customer();
        return (Customer) converter(v,target.getClass());
    }

    @Override public RespCustomerVO d2v(Customer d) {
        RespCustomerVO target=new RespCustomerVO();
        return (RespCustomerVO) converter(d,target.getClass());
    }

    @Override public List<RespCustomerVO> d2vs(List<Customer> d) {
        RespCustomerVO target=null;
        List<RespCustomerVO> list=new ArrayList<>();
        for (Customer Customer:d){
            target=new RespCustomerVO();
            RespCustomerVO respCustomerVO = (RespCustomerVO) converter(Customer, target.getClass());
            list.add(respCustomerVO);
        }
        return list;
    }

    @Override public List<Customer> v2ds(List<RespCustomerVO> v) {
        Customer target=null;
        List<Customer> list=new ArrayList<>();
        for (RespCustomerVO respCustomerVO:v){
            target=new Customer();
            Customer Customer = (Customer) converter(respCustomerVO, target.getClass());
            list.add(Customer);
        }
        return list;
    }
}
