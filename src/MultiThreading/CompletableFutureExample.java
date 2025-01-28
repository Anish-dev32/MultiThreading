package MultiThreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("worker");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "OK";
        });
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("worker");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "OK";
        }).thenApply(x -> x.concat("Done"));
        System.out.println(cf2.get());
        CompletableFuture<Void> f = CompletableFuture.allOf(cf1, cf2);
        f.join();
        System.out.println("Main thread");
    }
}
