package cn.xhu.converter.impl;

import cn.xhu.converter.OutboundConverter;
import cn.xhu.core.pojo.Inbound;
import cn.xhu.core.pojo.Outbound;
import cn.xhu.core.req.outbound.ReqOutboundVO;
import cn.xhu.core.resp.RespInboundVO;
import cn.xhu.core.resp.RespOutboundVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/16 20:46
 *@desciption:
 *
 */
@Service
public class OutboundConverterImpl extends BaseConverter implements OutboundConverter {
    @Override public Outbound v2d(RespOutboundVO v) {
        Outbound target=new Outbound();
        return (Outbound) converter(v,target.getClass());
    }

    @Override public Outbound v2d(ReqOutboundVO v) {
        Outbound target=new Outbound();
        return (Outbound) converter(v,target.getClass());
    }

    @Override public RespOutboundVO d2v(Outbound d) {
        RespOutboundVO target = new RespOutboundVO();
        return (RespOutboundVO) converter(d,target.getClass());
    }

    @Override public List<RespOutboundVO> d2vs(List<Outbound> d) {
        RespOutboundVO target=null;
        List<RespOutboundVO> list=new ArrayList<>();
        for (Outbound outbound:d){
            target=new RespOutboundVO();
            RespOutboundVO respOutboundVO = (RespOutboundVO) converter(outbound, target.getClass());
            list.add(respOutboundVO);
        }
        return list;
    }

    @Override public List<Outbound> v2ds(List<RespOutboundVO> v) {
        Outbound target=null;
        List<Outbound> list=new ArrayList<>();
        for (RespOutboundVO respOutboundVO:v){
            target=new Outbound();
            Outbound outbound = (Outbound) converter(respOutboundVO, target.getClass());
            list.add(outbound);
        }
        return list;
    }
}
