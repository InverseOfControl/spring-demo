package com.example.springbootproxy.proxy;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.Set;

/**
 * 接口扫描类
 *
 * @author 高宏旭
 * @date 2022/4/25 0025 10:19
 */
public class ServiceInterfacesScanner extends ClassPathBeanDefinitionScanner {
    public ServiceInterfacesScanner(BeanDefinitionRegistry registry) {
        super(registry, false);
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        addIncludeFilter((metadataReader, metadataReaderFactory) -> true);

        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);

        // 为扫描到的类创建代理对象
        for (BeanDefinitionHolder holder : beanDefinitionHolders) {
            GenericBeanDefinition beanDefinition = (GenericBeanDefinition) holder.getBeanDefinition();

            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
            // 通过 FactoryBean.getObject() 获取代理类
            beanDefinition.setBeanClass(ServiceProxyFactoryBean.class);
            beanDefinition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        }

        return beanDefinitionHolders;
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        AnnotationMetadata metadata = beanDefinition.getMetadata();
        String[] interfaceNames = metadata.getInterfaceNames();
        return metadata.isInterface() && metadata.isIndependent() && Arrays.asList(interfaceNames).contains(BaseService.class.getName());
    }
}
