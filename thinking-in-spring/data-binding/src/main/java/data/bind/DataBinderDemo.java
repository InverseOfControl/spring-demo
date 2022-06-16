package data.bind;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据绑定示例
 *
 * @date 2022/1/10 0010 22:11
 * @see DataBinder
 */
public class DataBinderDemo {
    public static void main(String[] args) {
        // 创建一个空对象
        User user = new User();
        DataBinder binder = new DataBinder(user);

        // 数据来源
        // company.address 框架底层做了 Company company = new Company();
        // user.setCompany(company);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "张三");
        map.put("company.address", "地址");

        // 设置被绑定的数据来源
        PropertyValues propertyValues = new MutablePropertyValues(map);

        // 绑定数据到对象上
        // 忽略位置的字段 ignoreUnknownFields = true;
        binder.setIgnoreUnknownFields(false);
        // 忽略无效的字段  ignoreInvalidFields = false;
        // 自动增加嵌套路径 autoGrowNestedPaths = true;

        // 白名单 allowedFields;

        // 黑名单 disallowedFields;

        // 必须字段 requiredFields;

        binder.bind(propertyValues);
        System.out.println(user);

        // 获取绑定结果信息，包含错误文案，但代码不报错。
        BindingResult bindingResult = binder.getBindingResult();
        System.out.println(bindingResult);
    }
}
