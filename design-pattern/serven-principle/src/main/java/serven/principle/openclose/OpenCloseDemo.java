package serven.principle.openclose;

/**
 * 开闭原则：依赖于抽象，对修改关闭，对扩展开放
 * 举例：对 Java 课程做优惠活动。并不是直接修改 JavaCourse, 而是扩展它。
 */
public class OpenCloseDemo {
    public static void main(String[] args) {
        JavaCourseDiscount course = new JavaCourseDiscount();
        System.out.println(course.getDiscountPrice());
    }
}
