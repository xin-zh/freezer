package cn.xhu.converter.impl;

import cn.xhu.converter.InboundConverter;
import cn.xhu.core.pojo.Inbound;
import cn.xhu.core.req.inbound.ReqInboundVO;
import cn.xhu.core.resp.RespInboundVO;
import cn.xhu.core.resp.RespMenuVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/16 18:32
 *@desciption:
 *
 */
@Service
public class InboundConverterImpl extends BaseConverter implements InboundConverter {
    @Override
    public Inbound v2d(RespInboundVO v) {
        Inbound target=new Inbound();
        return (Inbound) converter(v,target.getClass());
    }

    @Override
    public Inbound v2d(ReqInboundVO v) {
        Inbound target=new Inbound();
        return (Inbound) converter(v,target.getClass());
    }

    @Override
    public RespInboundVO d2v(Inbound d) {
        RespInboundVO target = new RespInboundVO();
        return (RespInboundVO) converter(d,target.getClass());
    }

    @Override
    public List<RespInboundVO> d2vs(List<Inbound> d) {
        RespInboundVO target=null;
        List<RespInboundVO> list=new ArrayList<>();
        for (Inbound inbound:d){
            target=new RespInboundVO();
            RespInboundVO respInboundVO = (RespInboundVO) converter(inbound, target.getClass());
            list.add(respInboundVO);
        }
        return list;
    }

    @Override
    public List<Inbound> v2ds(List<RespInboundVO> v) {
        Inbound target=null;
        List<Inbound> list=new ArrayList<>();
        for (RespInboundVO respInboundVO:v){
            target=new Inbound();
            Inbound inbound = (Inbound) converter(respInboundVO, target.getClass());
            list.add(inbound);
        }
        return list;
    }
}
