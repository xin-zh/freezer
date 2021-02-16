package cn.xhu.converter;

import cn.xhu.core.pojo.Inbound;
import cn.xhu.core.req.inbound.ReqInboundVO;
import cn.xhu.core.resp.RespInboundVO;

import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/16 18:19
 *@desciption:
 *
 */

public interface InboundConverter {
    Inbound v2d(RespInboundVO v);

    Inbound v2d(ReqInboundVO v);

    RespInboundVO d2v(Inbound d);

    List<RespInboundVO> d2vs(List<Inbound> d);

    List<Inbound> v2ds(List<RespInboundVO> v);
}
