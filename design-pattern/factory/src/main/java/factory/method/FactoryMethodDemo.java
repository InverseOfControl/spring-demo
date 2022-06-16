package factory.method;

import factory.pojo.Phone;

/**
 * 工厂方法让类的实例化推迟到的子类中进行
 * 每个产品都对应各自的工厂。
 * 创建产品找工厂就可以，无需关心具体细节。也符合开闭原则。
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        PhoneFactory factory = new AppleFactory();
        Phone phone = factory.createPhone();
        System.out.println(phone.getName());
    }
}
