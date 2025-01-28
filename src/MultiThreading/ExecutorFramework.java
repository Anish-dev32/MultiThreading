package MultiThreading;

import java.util.concurrent.*;

public class ExecutorFramework {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Future<?> submit = executorService.submit(() -> {
                return factorial(finalI);
                //System.out.println(result);
            });
            /*System.out.println(submit.get()); //.get() - wait for computation to complete and return output
            if(submit.isDone()){
                System.out.println("Done with "+ i);
            }*/
        }
        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(6, TimeUnit.SECONDS)){
                System.out.println("Waiting!");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main exit");
    }

    private static long factorial(int n){
        long fact = 1;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        System.out.println(fact);
        return fact;
    }
}
