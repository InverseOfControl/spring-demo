package factory.method;

import factory.pojo.HuaWeiPhone;
import factory.pojo.Phone;

public class HuaWeiFactory extends PhoneFactory {
    @Override
    Phone createPhone() {
        return new HuaWeiPhone();
    }
}
