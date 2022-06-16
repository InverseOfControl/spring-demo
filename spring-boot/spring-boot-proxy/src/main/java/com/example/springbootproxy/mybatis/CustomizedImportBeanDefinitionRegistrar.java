package com.example.springbootproxy.mybatis;

import com.example.springbootproxy.mybatis.code.DemoDao;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class CustomizedImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        List<Class> interfaceList = new ArrayList<>();
        interfaceList.add(DemoDao.class);

        for (Class clazz : interfaceList) {
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
            GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();

            beanDefinition.setBeanClass(CustomizedFactoryBean.class);
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(clazz);
            beanDefinition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);

            registry.registerBeanDefinition(clazz.getSimpleName(), beanDefinition);
        }
    }
}
