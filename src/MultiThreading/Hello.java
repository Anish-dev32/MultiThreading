package MultiThreading;

import jdk.jfr.Threshold;

import java.util.concurrent.Callable;

public class Hello implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    /*@Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return Thread.currentThread().getName();
    }*/

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });
        Thread t2 = new Thread(new Hello());

        t1.start();
        t2.start();
    }
}
