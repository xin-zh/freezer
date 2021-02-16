package cn.xhu.biz.service.impl;

import cn.xhu.biz.dao.OutBoundDao;
import cn.xhu.biz.dao.OutBoundItemDao;
import cn.xhu.biz.service.OutboundService;
import cn.xhu.common.utils.BeanUtils;
import cn.xhu.common.utils.CollectionUtils;
import cn.xhu.converter.OutboundConverter;
import cn.xhu.core.pojo.Outbound;
import cn.xhu.core.pojo.OutboundItemInfo;
import cn.xhu.core.req.outbound.ReqOutboundVO;
import cn.xhu.core.req.outbound.ReqPageQueryOutboundVO;
import cn.xhu.core.req.outbound.SaveOutBoundReqVO;
import cn.xhu.core.resp.RespOutboundVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *@author:zx
 *@create time:2021/2/16 20:53
 *@desciption:
 *
 */
@Service
public class OutboundServiceImpl implements OutboundService {
    @Resource
    private OutBoundDao outBoundDao;

    @Resource
    private OutBoundItemDao outBoundItemDao;

    @Resource
    private OutboundConverter outboundConverter;

    @Override
    public Long saveOutbound(SaveOutBoundReqVO request) {
        ReqOutboundVO reqOutboundVO=new ReqOutboundVO();
        BeanUtils.copyProperties(request,reqOutboundVO);
        Long outboundId=null;
        //新增
        if (request.getId()==null){
            outboundId = outBoundDao.insert(reqOutboundVO);
            if (CollectionUtils.isNotEmpty(request.getItems())){
                request.getItems().stream().forEach(t->outBoundItemDao.insert(t));
            }
        }
        else {
            outboundId=outBoundDao.update(reqOutboundVO);
            List<OutboundItemInfo> items = outBoundItemDao.queryAllItems(request.getOutboundNo());
            if (CollectionUtils.isNotEmpty(items)){
                List<String> itemNames = items.stream().map(t -> t.getItemName()).collect(Collectors.toList());
                for (OutboundItemInfo item : request.getItems()){
                    if (itemNames.contains(item.getItemName())){
                        outBoundItemDao.update(item);
                    }else{
                        outBoundItemDao.insert(item);
                    }
                }
            }
        }
        return outboundId;
    }

    @Override
    public List<RespOutboundVO> queryPageOutbounds(ReqPageQueryOutboundVO query) {
        List<Outbound> outbounds = outBoundDao.queryPageOutbound(query);
        List<RespOutboundVO> respOutboundVOS=null;
        if (CollectionUtils.isNotEmpty(outbounds)){
            respOutboundVOS = outboundConverter.d2vs(outbounds);
            respOutboundVOS.stream().forEach(t->{
                List<OutboundItemInfo> items = outBoundItemDao.queryAllItems(t.getOutboundNo());
                t.setItems(items);
            });
        }
        return respOutboundVOS;
    }

    @Override
    public RespOutboundVO queryById(Long outboundId) {
        RespOutboundVO respOutboundVO=null;
        try{
            Outbound outbound = outBoundDao.queryById(outboundId);
            respOutboundVO = outboundConverter.d2v(outbound);
            List<OutboundItemInfo> items = outBoundItemDao.queryAllItems(outbound.getOutboundNo());
            if (CollectionUtils.isNotEmpty(items)) {
                respOutboundVO.setItems(items);
            }
        }catch (Exception e){
            throw new SQLException("查询出库订单失败");
        }finally {
            return respOutboundVO;
        }

    }
}
