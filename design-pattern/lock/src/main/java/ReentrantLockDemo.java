import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static Lock lock = new ReentrantLock();

    private static int count = 0;

    private static void inc() {
        lock.lock();
        try {
            count++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> ReentrantLockDemo.inc(), String.valueOf(i)).start();
        }

        Thread.sleep(2000);

        System.out.println(count);
    }
}
