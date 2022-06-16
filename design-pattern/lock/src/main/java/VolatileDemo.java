public class VolatileDemo {

    // 可见性问题
    private static volatile boolean bool = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (bool) {
                System.out.printf("终止线程");
                break;
            }
        }, "volatile");

        t1.start();

        bool = true;
    }
}
