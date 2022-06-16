package serven.principle.openclose;

public class JavaCourse implements ICourse {
    @Override
    public Integer getId() {
        return 0;
    }

    @Override
    public String getName() {
        return "Java 课程";
    }

    @Override
    public Integer getPrice() {
        return 200;
    }
}
