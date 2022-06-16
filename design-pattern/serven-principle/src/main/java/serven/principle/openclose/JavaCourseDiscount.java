package serven.principle.openclose;

/**
 * 对 Java 课程进行打折
 */
public class JavaCourseDiscount extends JavaCourse {

    public Double getDiscountPrice() {
        return super.getPrice() * 0.8;
    }

}
