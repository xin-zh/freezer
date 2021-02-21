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
import cn.xhu.enums.OutBoundStatusEnum;
import com.alibaba.fastjson.JSON;
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
        //新增预约
        if (request.getId()==null){
            outboundId = outBoundDao.insert(reqOutboundVO);
        }else{
            outboundId=outBoundDao.update(reqOutboundVO);
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


    @Override
    public Long changeStatus(Long id, Integer status) {
        return outBoundDao.updateStatus(id, status);
    }

    /**
     * 处理出库，前台确认出库后，将出库子项数据插入数据表中
     * @param outboundId
     * @return
     */
    @Override
    public boolean handleOutbound(Long outboundId) throws SQLException {
        boolean result=false;
        try{
            Outbound outbound = outBoundDao.queryById(outboundId);
            //将扩展信息中的数据转为outboundItem对象并保存到数据库
            List<OutboundItemInfo> items = JSON.parseArray(outbound.getExtInfo(), OutboundItemInfo.class);
            items.stream().forEach(t->outBoundItemDao.insert(t));
            //更新出库订单状态
            Long id = outBoundDao.updateStatus(outboundId, OutBoundStatusEnum.IN_STOCK.getCode());
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
