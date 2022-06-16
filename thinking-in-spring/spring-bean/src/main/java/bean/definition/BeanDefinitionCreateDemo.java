package bean.definition;

import ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * BeanDefinition 构建示例
 *
 * Bean 的名称 API：
 * {@link org.springframework.beans.factory.support.BeanNameGenerator}
 */
public class BeanDefinitionCreateDemo {
    public static void main(String[] args) {
        // 1.通过 BeanDefinitionBuilder 的方式构建
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("id", 3L);
        builder.addPropertyValue("name", "高宏旭");
        System.out.println(builder.getBeanDefinition().getPropertyValues());
        System.out.println(builder.getBeanDefinition().isSingleton());

        // 2.通过 BeanDefinition 的派生类构建
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", 3L);
        propertyValues.add("name", "高宏旭");
        genericBeanDefinition.setPropertyValues(propertyValues);
        System.out.println(builder.getBeanDefinition().getPropertyValues());
    }
}
