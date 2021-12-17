import com.achacker.config.Config;
import com.achacker.pojo.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        // ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Client user = context.getBean("user", Client.class);

        System.out.println(user);
    }
}
