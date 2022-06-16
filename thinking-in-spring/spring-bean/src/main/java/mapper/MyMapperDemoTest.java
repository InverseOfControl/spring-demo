package mapper;

import mapper.ifc.MyDao;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyMapperDemoTest {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyMapperDemoTest.class);

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
        beanDefinition.setBeanClass(MyDaoFactoryBean.class);
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(MyDao.class);
        beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        context.registerBeanDefinition(MyDao.class.getSimpleName(), beanDefinition);

        context.refresh();

        MyDao myDao = context.getBean(MyDao.class);
        System.out.println(myDao.hello());
    }
}
