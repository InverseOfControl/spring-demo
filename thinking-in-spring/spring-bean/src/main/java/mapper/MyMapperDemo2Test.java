package mapper;

import mapper.ifc.BaseDao;
import mapper.ifc.MyDao;
import mapper.ifc.MyDao2;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

public class MyMapperDemo2Test {
    public static void main(String[] args) throws Exception {
        String basePackage = "mapper.ifc";
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyMapperDemo2Test.class);

        DaoScanner daoScanner = new DaoScanner(context);
        Set<BeanDefinitionHolder> beanDefinitionHolders = daoScanner.doScan(basePackage);
        for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
            GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanDefinitionHolder.getBeanDefinition();
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
            beanDefinition.setBeanClassName(MyDao2FactoryBean.class.getName());
        }
        context.refresh();
        MyDao myDao = context.getBean(MyDao.class);
        MyDao2 myDao2 = context.getBean(MyDao2.class);
        System.out.println(myDao.hello());
        System.out.println(myDao2.hello2());
    }

    private static class DaoScanner extends ClassPathBeanDefinitionScanner {
        public DaoScanner(BeanDefinitionRegistry registry) {
            super(registry);
        }

        @Override
        public Set<BeanDefinitionHolder> doScan(String... basePackages) {
            return super.doScan(basePackages);
        }

        @Override
        public boolean isCandidateComponent(MetadataReader metadataReader) throws IOException {
            return true;
        }

        @Override
        protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
            AnnotationMetadata metadata = beanDefinition.getMetadata();
            System.out.println(metadata.getSuperClassName());
            return metadata.isInterface() && Arrays.asList(metadata.getInterfaceNames()).contains(BaseDao.class.getName());
        }
    }
}
