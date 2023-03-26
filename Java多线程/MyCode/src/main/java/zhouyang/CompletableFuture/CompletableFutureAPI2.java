package zhouyang.CompletableFuture;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/17 0:38
 * @description : thenAccept接受任务处理结果 并消费处理 无返回结果
 */
public class CompletableFutureAPI2 {

    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> 1)
                .thenApply(f -> f + 2)
                .thenApply(f -> f + 3)
                .thenApply(f -> f + 4)
                .thenAccept(System.out::println);

        completeRunAcceptApply();
    }

    // 比较 thenRun、thenAccept、thenApply
    /*
    * ① thenRun：thenRun(Runnable runnable) 任务 A 执行完执行 B，并且 B 不需要 A 的结果
        ② thenAccept：thenAccept(Consumer action) 任务 A 执行完执行 B，B 需要 A 的结果，但是任务 B 无返回值
        ③ thenApply：thenApply(Function fn) 任务 A 执行完执行 B，B 需要 A 的结果，同时任务 B 有返回值
    *
    * */

    private static void completeRunAcceptApply() {

        System.out.println(CompletableFuture.supplyAsync(() -> "rusultA").thenRun(() -> {}).join());

        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenAccept(resultA -> {
        }).join());

        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenApply(resultA -> resultA + " resultB").join());

    }


}
