package cn.xhu.biz.dao;

import cn.xhu.core.pojo.InboundItemInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/16 17:23
 *@desciption:
 *
 */

public interface InboundItemDao {
    List<InboundItemInfo> queryAllItems(@Param("inboundNo") String inboundNo);

    Long insert(InboundItemInfo item);

    Long update(InboundItemInfo item);
}
