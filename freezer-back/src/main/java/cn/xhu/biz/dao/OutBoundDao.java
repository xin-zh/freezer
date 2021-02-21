package cn.xhu.biz.dao;

import cn.xhu.core.pojo.Outbound;
import cn.xhu.core.req.outbound.ReqOutboundVO;
import cn.xhu.core.req.outbound.ReqPageQueryOutboundVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/16 20:27
 *@desciption:
 *
 */

public interface OutBoundDao {
    List<Outbound> queryPageOutbound(ReqPageQueryOutboundVO pageQuery);

    Long insert(ReqOutboundVO request);

    Long update(ReqOutboundVO request);

    Outbound queryById(@Param("id") Long id);

    Long updateStatus(@Param("outboundId") Long outBoundId,@Param("status") Integer status);

}
