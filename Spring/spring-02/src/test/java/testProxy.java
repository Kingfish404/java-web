import com.achacker.proxy.ProxyInvocationHandler;
import com.achacker.proxy.User;
import com.achacker.proxy.UserImpl;
import org.junit.Test;

public class testProxy {

    @Test
    public void testProxy() {
        // 真实角色
        UserImpl user = new UserImpl();
        // 代理角色
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        // 设置代理对象
        pih.setTarget(user);
        // 动态生成代理类
        User proxy_user = (User) pih.getProxy();
        proxy_user.sayHello();
    }
}

