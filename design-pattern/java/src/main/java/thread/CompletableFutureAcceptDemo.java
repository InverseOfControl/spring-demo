package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureAcceptDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //CompletableFuture.supplyAsync(() -> "hello").thenAccept(rs -> System.out.println(rs));

        /*CompletableFuture.supplyAsync(() -> CompletableFutureAcceptDemo.fun1())
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> CompletableFutureAcceptDemo.fun2()), (rs1, rs2) -> System.out.println(rs1 + rs2))
                .get();*/

        CompletableFuture.allOf(
                CompletableFuture.supplyAsync(() -> CompletableFutureAcceptDemo.fun1()),
                CompletableFuture.supplyAsync(() -> CompletableFutureAcceptDemo.fun2()),
                CompletableFuture.supplyAsync(() -> CompletableFutureAcceptDemo.fun3()),
                CompletableFuture.supplyAsync(() -> CompletableFutureAcceptDemo.fun4())
        ).whenComplete((rs, ex) -> {
            System.out.println(rs);
            if (ex != null) {
                ex.printStackTrace();
                System.out.println("执行异常了");
            } else {
                System.out.println("执行成功了");
            }
        });
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
