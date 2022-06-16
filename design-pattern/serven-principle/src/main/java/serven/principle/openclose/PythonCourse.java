package serven.principle.openclose;

public class PythonCourse implements ICourse {
    @Override
    public Integer getId() {
        return 1;
    }

    @Override
    public String getName() {
        return "Python 课程";
    }

    @Override
    public Integer getPrice() {
        return 100;
    }
}
