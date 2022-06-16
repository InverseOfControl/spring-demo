package ioc.overview.container;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ioc 容器生命周期
 * 启动
 * 运行
 * 终止
 */
public class IocLifecycleDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext();

        configApplicationContext.register(IocContainerDemo.class);

        // 启动
        configApplicationContext.refresh();

        // 关闭
        configApplicationContext.close();
    }
}
