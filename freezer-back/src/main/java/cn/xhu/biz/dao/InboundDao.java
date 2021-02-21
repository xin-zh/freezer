package cn.xhu.biz.dao;

import cn.xhu.core.pojo.Inbound;
import cn.xhu.core.req.inbound.ReqInboundVO;
import cn.xhu.core.req.inbound.ReqPageQueryInboundVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/16 17:23
 *@desciption:
 *
 */

public interface InboundDao {
    List<Inbound> queryPageInbound(ReqPageQueryInboundVO pageQuery);

    Long insert(ReqInboundVO request);

    Long update(ReqInboundVO request);

    Inbound queryById(@Param("id") Long id);

    void delete(Long id);

    Long updateStatus(@Param("inboundId") Long inboundId, @Param("status") Integer status);
}
