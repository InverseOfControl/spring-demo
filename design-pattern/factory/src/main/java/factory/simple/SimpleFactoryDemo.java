package factory.simple;

import factory.pojo.ApplePhone;
import factory.pojo.Phone;

/**
 * 工程模式属于创建型设计模式。
 *
 * 它是把创建的过程包装起来，交给工厂统一处理。也就是把 new 代码交给工厂。
 * 目的就是简化客户端的调用。
 */
public class SimpleFactoryDemo {
    public static void main(String[] args) {
        // 客户端还是要传入具体的类，违背了迪米特法则
        Phone phone = SimpleFactory.createPhone(ApplePhone.class);
        System.out.println(phone.getName());
    }

    private static class SimpleFactory {
        public static Phone createPhone(Class<? extends Phone> clazz) {
            try {
                return clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
