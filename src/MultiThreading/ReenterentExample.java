package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterentExample {

    /*
    * If single thread lock critical section, and it again finds another lock instruction,
    * it ll lock it and keep locked it until number of locks are not unlocked.
    */

    private final Lock lock = new ReentrantLock();

    public void outerMethod(){
        lock.lock();
        try {
            System.out.println("Outer method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    private void innerMethod() {
        lock.lock();
        try{
            System.out.println("Inner Method");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReenterentExample example = new ReenterentExample();
        example.outerMethod();
    }

}
