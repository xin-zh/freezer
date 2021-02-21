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
import cn.xhu.enums.InboundStatusEnum;
import com.alibaba.fastjson.JSON;
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
        }else{//修改
            inboundId = inboundDao.update(reqInboundVO);
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

    @Override public Long changeStatus(Long inboundId, Integer status) {
        return inboundDao.updateStatus(inboundId, status);
    }

    @Override public boolean handleInbound(Long inboundId) throws SQLException {
        boolean result=false;
        try {
            Inbound inbound = inboundDao.queryById(inboundId);
            List<InboundItemInfo> items = JSON.parseArray(inbound.getExtInfo(), InboundItemInfo.class);
            items.stream().forEach(t -> inboundItemDao.insert(t));
            Long id = inboundDao.updateStatus(inboundId, InboundStatusEnum.IN_STOCK.getCode());
            if (id>0){
                result=true;
            }
        }catch (Exception e){
            throw new SQLException("数据库保存异常");
        }finally {
            return result;
        }
    }
}
