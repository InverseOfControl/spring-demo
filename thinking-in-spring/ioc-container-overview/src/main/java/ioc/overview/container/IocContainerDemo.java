package ioc.overview.container;

import ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * ioc 容器示例
 */
public class IocContainerDemo {
    public static void main(String[] args) {
        iocFromXml();

        iocFromAnnotation();
    }

    private static void iocFromAnnotation() {
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext();
        configApplicationContext.register(IocContainerDemo.class);

        configApplicationContext.refresh();
    }

    private static void iocFromXml() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        String location = "/META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(location);
    }

    @Bean
    private static User user() {
        User user = new User();
        user.setId(2L);
        user.setName("测试");
        return user;
    }
}
