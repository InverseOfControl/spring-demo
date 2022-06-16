import org.springframework.core.ResolvableType;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class ResolvableTypeDemo {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person();
        person.setName("ceshi");
        person.setAge(10);
        System.out.println(Objects.toString(readValue(person, "age"), ""));
    }

    public static <T, R> R readValue(T obj, String fieldName) {
        ResolvableType resolvableType = ResolvableType.forClass(Person.class);
        Field[] fields = resolvableType.resolve().getDeclaredFields();

        R r = null;
        Optional<Field> optional = Arrays.stream(fields).filter(field -> field.getName().equals(fieldName)).findFirst();
        if (optional.isPresent()) {
            Field field = optional.get();
            field.setAccessible(true);
            try {
                return (R) field.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return r;
    }

    static class Person {
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
