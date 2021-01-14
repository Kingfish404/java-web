import com.achacker.config.Config;
import com.achacker.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        // ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        User user = context.getBean("user", User.class);

        System.out.println(user);
    }
}
