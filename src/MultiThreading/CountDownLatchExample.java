package MultiThreading;

import java.util.concurrent.*;

public class CountDownLatchExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfServices  =3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        CountDownLatch latch = new CountDownLatch(numberOfServices);
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        latch.await();

        /*Future<String> submit1 = executorService.submit(new DependentService());
        Future<String> submit2 = executorService.submit(new DependentService());
        Future<String> submit3 = executorService.submit(new DependentService());

        *//*List<Callable<String>> tasks = Arrays.asList(new DependentService(),new DependentService(), new DependentService());
        List<Future<String>> results = executorService.invokeAll(tasks);

        for (Future<String> result : results) {
            try {
                System.out.println(result.get()); // Get the result of each task
            } catch (ExecutionException e) {
                System.out.println("Task failed with exception: " + e.getCause());
            }
        }*//*

        System.out.println(submit1.get());
        System.out.println(submit2.get());
        System.out.println(submit3.get());
        */

        System.out.println("back to main thread!");
        executorService.shutdown();
    }
}

class DependentService implements Callable<String> {
    private final CountDownLatch latch;

    DependentService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" service started.");
        Thread.sleep(2000);
        latch.countDown();
        return "ok";
    }
}