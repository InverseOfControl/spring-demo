package mapper;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyDao2FactoryBean extends AbstractFactoryBean {

    private final Class interfaces;

    public MyDao2FactoryBean(Class interfaces) {
        this.interfaces = interfaces;
    }

    @Override
    public Class<?> getObjectType() {
        return interfaces;
    }

    @Override
    protected Object createInstance() throws Exception {
        return Proxy.newProxyInstance(
                this.interfaces.getClassLoader(), new Class[]{interfaces}, new EarlySingletonInvocationHandler());
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    private class EarlySingletonInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.getName();
        }
    }
}
