package cn.xhu.converter;

import cn.xhu.core.pojo.Outbound;
import cn.xhu.core.req.outbound.ReqOutboundVO;
import cn.xhu.core.resp.RespOutboundVO;

import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/16 20:45
 *@desciption:
 *
 */

public interface OutboundConverter  {
    Outbound v2d(RespOutboundVO v);

    Outbound v2d(ReqOutboundVO v);

    RespOutboundVO d2v(Outbound d);

    List<RespOutboundVO> d2vs(List<Outbound> d);

    List<Outbound> v2ds(List<RespOutboundVO> v);
}
