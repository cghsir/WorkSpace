import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cghsir on 2017/7/10.
 */
public class TestShiro01 {

    private String username = "zhang";
    private String password = "123";

    /**
     * 测试原始ini方式的shiro认证
     */
    @Test
    public void testShiro() {
        this.doTest("shiro.ini", username, password);
    }

    /**
     * 测试自定义realm实现的shiro认证
     */
    @Test
    public void testShiroRealm(){
        this.doTest("shiro-realm.ini", username, password);
    }

    /**
     * TODO jdbc方式 realm报错。初步判定错误原因 druid的连接被mysql收回了 而druid不知道。
     */
    @Test
    public void testShiroJdbcRealm(){
        this.doTest("shiro-jdbc-realm.ini", username, password);
    }

    private void doTest(String fileName,String username,String password) {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
//        Factory<SecurityManager> factory =
//                new IniSecurityManagerFactory("classpath:shiro.ini");
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:" + fileName);
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            //4、登录，即身份验证
            subject.login(token);
            System.out.println("登录成功！");
        } catch (AuthenticationException e) {
            //5、身份验证失败
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6、退出
        subject.logout();
    }
}
