package MultiThreading;

import java.util.concurrent.*;

public class CyclicBarrierExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException, BrokenBarrierException {
        int numberOfServices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        CyclicBarrier barrier = new CyclicBarrier(numberOfServices);
        executorService.submit(new DependentClass(barrier));
        executorService.submit(new DependentClass(barrier));
        executorService.submit(new DependentClass(barrier));
        System.out.println("back to main thread!");
        executorService.shutdown();
    }
}
class DependentClass implements Callable<String> {
    private final CyclicBarrier barrier;

    DependentClass(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" service started.");
        Thread.sleep(2000);
        barrier.await();
        return "ok";
    }
}