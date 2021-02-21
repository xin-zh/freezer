package cn.xhu.biz.dao;

import cn.xhu.core.pojo.Delivery;
import cn.xhu.core.pojo.Inbound;
import cn.xhu.core.req.delivery.ReqDeliveryVO;
import cn.xhu.core.req.delivery.ReqPageQueryDeliveryVO;
import cn.xhu.core.req.inbound.ReqInboundVO;
import cn.xhu.core.req.inbound.ReqPageQueryInboundVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/20 21:09
 *@desciption:
 *
 */

public interface DeliveryDao {
    List<Delivery> queryPageDelivery(ReqPageQueryDeliveryVO pageQuery);

    Long insert(ReqDeliveryVO request);

    Long update(ReqDeliveryVO request);

    Delivery queryById(@Param("id") Long id);
}
