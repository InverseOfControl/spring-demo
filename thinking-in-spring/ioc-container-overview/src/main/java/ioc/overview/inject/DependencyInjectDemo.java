package ioc.overview.inject;

import ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * beanFactory 可以依赖注入，但是不能够依赖查找，为什么呢？
 * 因为 beanFactory 是一个 spring 的内建对象。
 * <p>
 * Spring 依赖注入和查找的来源：
 * 自定义 bean
 * 内建 bean
 * 容器内建依赖
 *
 * beanFactory 和 applicationContext 谁才是真正的 ioc 容器？
 * 从官方文档和源码可知，applicationContext 才是真正的 ioc 容器, 通过它的 getBeanFactory 方法
 * 才能获取到真正的 beanFactory。
 */
public class DependencyInjectDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory =
                new ClassPathXmlApplicationContext("/META-INF/dependency-inject-context.xml");
        UserRepository userRepository = beanFactory.getBean(UserRepository.class);

        System.out.println("普通 bean : " + userRepository.getUsers());

        System.out.println("beanFactory : " + userRepository.getBeanFactory());

        System.out.println("上下文 bean : " + userRepository.getObjectFactory().getObject());

        System.out.println("内建 bean Environment : " + beanFactory.getBean(Environment.class));
    }
}
