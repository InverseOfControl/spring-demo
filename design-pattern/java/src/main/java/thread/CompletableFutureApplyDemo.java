package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureApplyDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String str = CompletableFuture.supplyAsync(() -> CompletableFutureApplyDemo.fun1())
                .thenApplyAsync(rs -> rs + "111").get();
        System.out.println(str);


    }

    public static String fun1() {
        return "hello";
    }

    public static String fun2() {
        return "world";
    }

    public static String fun3() {
        return "you";
    }

    public static double fun4() {
        return 1 / 0;
    }
}
