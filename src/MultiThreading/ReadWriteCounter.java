package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {

    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    /*
    * allows multiple read lock to access critical resource when write lock is not there.
    * which make read many write once.
    * */
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment(){
        writeLock.lock();
        try {
            count++;
        }finally {
            writeLock.unlock();
        }
    }

    public int getCount(){
        readLock.lock();
        try{
            return count;
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteCounter counter = new ReadWriteCounter();

        Runnable readtask = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    System.out.println(Thread.currentThread().getName()+ " read: "+counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    counter.increment();
                    System.out.println(Thread.currentThread().getName()+ " write: "+counter.getCount());
                }
            }
        };

        Thread writeThread1 = new Thread(writeTask);
        Thread readThread1 = new Thread(readtask);
        Thread readThread2 = new Thread(readtask);

        writeThread1.start();
        readThread1.start();
        readThread2.start();

        writeThread1.join();
        readThread1.join();
        readThread2.join();

        System.out.println("Final count: "+counter.getCount());
    }
}
