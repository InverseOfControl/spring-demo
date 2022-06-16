package enable.driver;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld() {
        return "hello,world";
    }
}
