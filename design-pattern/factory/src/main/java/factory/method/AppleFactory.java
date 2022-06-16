package factory.method;

import factory.pojo.ApplePhone;
import factory.pojo.Phone;

public class AppleFactory extends PhoneFactory {
    @Override
    Phone createPhone() {
        return new ApplePhone();
    }
}
