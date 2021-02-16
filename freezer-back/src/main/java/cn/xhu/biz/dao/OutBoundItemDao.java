package cn.xhu.biz.dao;

import cn.xhu.core.pojo.InboundItemInfo;
import cn.xhu.core.pojo.OutboundItemInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/16 20:41
 *@desciption:
 *
 */

public interface OutBoundItemDao {
    List<OutboundItemInfo> queryAllItems(@Param("outboundNo") String outboundNo);

    Long insert(OutboundItemInfo item);

    Long update(OutboundItemInfo item);
}
