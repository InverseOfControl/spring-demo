package ioc.overview.lookup;

import ioc.overview.annotation.Super;
import ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 通过名称的方式查找：
 * 实时查找
 * 延时查找
 * @see org.springframework.beans.factory.ObjectFactory 提供延时查找
 *
 * <p>
 * 通过类型的方式查找：
 * 集合查找通过 ListableBeanFactory 进行操作。通过前缀 Listable 就可知道它是用于查找对象集合的
 * 单一类型 org.springframework.beans.factory.BeanFactory#getBean(java.lang.Class)
 * 集合类型 org.springframework.beans.factory.ListableBeanFactory#getBeansOfType(java.lang.Class)
 * <p>
 *
 * 通过注解查找：
 * 根据注解查找，只会查找到标注@Super注解的类
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        // 配置 xml 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory =
                new ClassPathXmlApplicationContext("/META-INF/dependency-lookup-context.xml");

        // 根据名称查找
        User user = (User) beanFactory.getBean("user");
        System.out.println(user);

        // 根据类型查找（集合）
        lookupCollectionByType(beanFactory);

        // 通过注解的方式查找
        lookupByAnnotation(beanFactory);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = ListableBeanFactory.class.cast(beanFactory);
            Map<String, User> userMap = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("根据注解查找: " + userMap);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = ListableBeanFactory.class.cast(beanFactory);
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("根据类型查找（集合）: " + userMap);
        }
    }
}
