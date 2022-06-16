package mapper;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.Statement;

public class MyDaoFactoryBean implements FactoryBean, InvocationHandler {

    private final Class interfaces;

    public MyDaoFactoryBean(Class interfaces) {
        this.interfaces = interfaces;
    }

    @Override
    public Object getObject() throws Exception {
        return Proxy.newProxyInstance(interfaces.getClassLoader(), new Class[]{interfaces}, this);
    }

    @Override
    public Class<?> getObjectType() {
        return interfaces;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(ExecuteSql.class)) {
            ExecuteSql executeSql = method.getDeclaredAnnotation(ExecuteSql.class);
            String sql = executeSql.value();

            String url = "jdbc:mysql://101.35.156.139:3306/procuratorate_zy?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=GMT%2b8&allowMultiQueries=true";
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl(url);
            dataSource.setUser("root");
            dataSource.setPassword("ww@123.com");

            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            ResultSetImpl rs = (ResultSetImpl) statement.executeQuery(sql);

            while (rs.next()) {
                return rs.getString("id");
            }

        }
        return method.getName();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
