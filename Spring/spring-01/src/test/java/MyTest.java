import com.achacker.pojo.Hello;
import com.achacker.pojo.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Hello hello = (Hello) context.getBean("hello");
        hello.sayHello();
        System.out.println(hello);

        People people = context.getBean("people", People.class);
        System.out.println(people);
    }
}
