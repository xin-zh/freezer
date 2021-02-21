package cn.xhu.biz.service;

import cn.xhu.core.req.inbound.ReqPageQueryInboundVO;
import cn.xhu.core.req.inbound.SaveInboundReqVO;
import cn.xhu.core.resp.RespInboundVO;

import java.sql.SQLException;
import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/16 17:48
 *@desciption:
 *
 */

public interface InboundService {
    /**
     * 保存入库信息
     * @param request
     * @return
     */
    Long saveInbound(SaveInboundReqVO request);

    List<RespInboundVO> queryPageInbounds(ReqPageQueryInboundVO query);

    RespInboundVO queryById(Long inboundId);

    Long changeStatus(Long inboundId,Integer status);

    boolean handleInbound(Long inboundId) throws SQLException;
}
