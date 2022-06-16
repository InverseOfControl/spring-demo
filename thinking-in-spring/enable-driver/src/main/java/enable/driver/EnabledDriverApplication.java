package enable.driver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Administrator
 */
@EnableHelloWorld
public class EnabledDriverApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnabledDriverApplication.class);
        context.refresh();

        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println(helloWorld);

        context.close();
    }
}
