package com.example.springbootproxy.mybatis;

import com.example.springbootproxy.mybatis.code.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan(basePackages = "com.example.springbootproxy.mybatis")
@Import(CustomizedImportBeanDefinitionRegistrar.class)
@RestController
public class MybatisDemo {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MybatisDemo.class);
        context.refresh();

        DemoService demoService = context.getBean(DemoService.class);
        System.out.println(demoService.query());
        System.out.println(demoService.toString());

        context.close();
    }

    @GetMapping("/query")
    public String query() {
        return "hello world";
    }
}
