import cn.xhu.biz.service.InboundService;
import cn.xhu.core.resp.RespInboundVO;
import org.junit.Test;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 *@author:zx
 *@create time:2021/2/16 18:39
 *@desciption:
 *
 */

public class TestInboundDB extends BaseTest {
    @Resource
    private InboundService inboundService;

    @Test
    public void test() throws SQLException {
        RespInboundVO respInboundVO = inboundService.queryById(1L);
        System.out.println(respInboundVO.getItems().size());
    }
}
