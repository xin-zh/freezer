package cn.xhu.biz.service;

import cn.xhu.core.req.inbound.ReqPageQueryInboundVO;
import cn.xhu.core.req.inbound.SaveInboundReqVO;
import cn.xhu.core.req.outbound.ReqPageQueryOutboundVO;
import cn.xhu.core.req.outbound.SaveOutBoundReqVO;
import cn.xhu.core.resp.RespInboundVO;
import cn.xhu.core.resp.RespOutboundVO;

import java.sql.SQLException;
import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/16 20:52
 *@desciption:
 *
 */

public interface OutboundService {
    /**
     * 保存出库信息
     * @param request
     * @return
     */
    Long saveOutbound(SaveOutBoundReqVO request);

    List<RespOutboundVO> queryPageOutbounds(ReqPageQueryOutboundVO query);

    RespOutboundVO queryById(Long outboundId);

    Long changeStatus(Long id,Integer status);

    boolean handleOutbound(Long outboundId) throws SQLException;
}
