import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author:zx
 * @create time:2021/2/12 19:52
 * @desciption:
 */


public class ShiroTest extends BaseTest {
    private IniRealm iniRealm=new IniRealm("classpath:user.ini");

    @Test
    public void test(){
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(iniRealm);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zs","123");
        subject.login(token);
        System.out.println("认证通过");
        subject.checkRole("admin");
        subject.checkPermission("user:list");
        System.out.println("授权通过");

    }

}
