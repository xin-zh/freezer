package cn.xhu.biz.service.impl;

import cn.xhu.biz.dao.InboundDao;
import cn.xhu.biz.dao.InboundItemDao;
import cn.xhu.biz.service.InboundService;
import cn.xhu.common.utils.BeanUtils;
import cn.xhu.common.utils.CollectionUtils;
import cn.xhu.converter.InboundConverter;
import cn.xhu.core.pojo.Inbound;
import cn.xhu.core.pojo.InboundItemInfo;
import cn.xhu.core.req.inbound.ReqInboundVO;
import cn.xhu.core.req.inbound.ReqPageQueryInboundVO;
import cn.xhu.core.req.inbound.SaveInboundReqVO;
import cn.xhu.core.resp.RespInboundVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *@author:zx
 *@create time:2021/2/16 18:05
 *@desciption:
 *
 */
@Service
public class InboundServiceImpl implements InboundService {
    @Resource
    private InboundDao inboundDao;
    @Resource
    private InboundItemDao inboundItemDao;
    @Resource
    private InboundConverter inboundConverter;

    @Override public Long saveInbound(SaveInboundReqVO request) {
        ReqInboundVO reqInboundVO=new ReqInboundVO();
        BeanUtils.copyProperties(request,reqInboundVO);
        Long inboundId=null;
        //新增
        if (request.getId()==null){
            inboundId = inboundDao.insert(reqInboundVO);
            //保存子项信息
            if(CollectionUtils.isNotEmpty(request.getItems())){
                request.getItems().stream().forEach(t->inboundItemDao.insert(t));
            }
        }else{//修改
            inboundId = inboundDao.update(reqInboundVO);
            List<InboundItemInfo> items = inboundItemDao.queryAllItems(request.getInboundNo());
            if(CollectionUtils.isNotEmpty(items)) {
                List<String> itemNames = items.stream().map(t -> t.getItemName()).collect(Collectors.toList());
                for (InboundItemInfo item : request.getItems()) {
                    if (itemNames.contains(item.getItemName())) {
                        inboundItemDao.update(item);
                    } else {
                        inboundItemDao.insert(item);
                    }
                }
            }
        }
        return inboundId;
    }

    @Override
    public List<RespInboundVO> queryPageInbounds(ReqPageQueryInboundVO query) {
        List<Inbound> inbounds = inboundDao.queryPageInbound(query);
        List<RespInboundVO> respInboundVOS=null;
        if(CollectionUtils.isNotEmpty(inbounds)){
            respInboundVOS = inboundConverter.d2vs(inbounds);
            respInboundVOS.stream().forEach(t->{
                List<InboundItemInfo> items = inboundItemDao.queryAllItems(t.getInboundNo());
                t.setItems(items);
            });
        }
        return respInboundVOS;
    }

    @Override public RespInboundVO queryById(Long inboundId) {
        RespInboundVO respInboundVO=null;
        try {
            Inbound inbound = inboundDao.queryById(inboundId);
            respInboundVO=inboundConverter.d2v(inbound);
            List<InboundItemInfo> items = inboundItemDao.queryAllItems(inbound.getInboundNo());
            if (CollectionUtils.isNotEmpty(items)){
                respInboundVO.setItems(items);
            }
        }catch (Exception e){
            throw new SQLException("查询入库订单信息失败");
        }finally {
            return respInboundVO;
        }
    }
}
