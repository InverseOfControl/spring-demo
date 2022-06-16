package com.example.springbootdesign.enable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableServer(type = Server.Type.HTTP)
public class EnableServerTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(EnableServerTest.class);

        annotationConfigApplicationContext.refresh();

        Server server = annotationConfigApplicationContext.getBean(Server.class);
        server.start();
        server.stop();

        annotationConfigApplicationContext.close();

    }
}
