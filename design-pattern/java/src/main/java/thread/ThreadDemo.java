package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * thenAccept  纯消费，无返回值
         * thenApply   有返回值
         * thenCombine 组合
         * when异常处理
         */

        CompletableFuture future = new CompletableFuture();
        // 无返回值
        CompletableFuture cf1 = CompletableFuture.runAsync(() -> {
            System.out.println("ThreadDemo.main");
        });

        // 不需要阻塞，把上一个步骤的结果作为下一个步骤的入参
        CompletableFuture cf2 = CompletableFuture
                .supplyAsync(() -> "hello")
                .thenAccept(rs -> System.out.println(rs));

        // 两个任务都完成
        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> "stage1");
        CompletableFuture<String> cf4 = CompletableFuture.supplyAsync(() -> "stage2");
        cf3.thenAcceptBoth(cf4, (r1, r2) -> {
            System.out.println(r1 + r2);
        });

        // 多个任务都完成
        CompletableFuture<Void> cf5 = CompletableFuture.allOf(CompletableFuture.supplyAsync(() -> "aaa"));

        // 异常处理
        CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("异常了");
        }).whenComplete((rs, ex) -> {
            if (ex != null) {
                System.out.println("捕获异常处理");
            }
        }).get();
        
        CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("异常了");
        }).exceptionally((ex) -> {
            System.out.println("ThreadDemo.main");
            return ex;
        }).get();
    }
}
