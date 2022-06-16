import data.bind.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.Arrays;

public class JavaBeansDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
        Arrays.stream(beanInfo.getPropertyDescriptors()).forEach(System.out::println);
        Arrays.stream(beanInfo.getMethodDescriptors()).forEach(System.out::println);
    }
}
