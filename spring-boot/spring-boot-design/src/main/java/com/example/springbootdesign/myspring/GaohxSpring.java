package com.example.springbootdesign.myspring;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class GaohxSpring {
    private Properties properties = new Properties();

    private Map<String, Object> ioc = new LinkedHashMap<>();

    void loadProperties(String contextLocation) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(contextLocation);
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void doScanner(String packages) {
        URL url = this.getClass().getClassLoader().getResource(packages);
        File classpath = new File(url.getFile());
        File[] files = classpath.listFiles();
        for (File file : files) {
            String classname = file.getName();
        }
    }

    void doInstance() {
        try {
            Class clazz = Class.forName(null);

            if (clazz.isAnnotationPresent(MyController.class)) {

            }

            String beanName = clazz.getSimpleName();
            Object instance = clazz.newInstance();

            // 放入 ioc 容器中
            ioc.put(beanName, instance);

            // 如果是接口，初始化它的实现类
            for (Class c : clazz.getInterfaces()) {
                ioc.put(c.getName(), instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
