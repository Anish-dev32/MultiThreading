package MultiThreading;

public class Threading {
    /*
    * CPU -> cores -> program(set of instruction) -> process(instance of program)
    * Thread - smallest unit of execution within process.
    * process can have multiple thread, which share resources but can run independently.
    * MultiTasking - allows OS to run multiple process simultaneously.
    * single core - OS switch between process rapidly., multicore - OS can run multiple processes parallel.(OS Scheduler)
    *
    * Time slicing - OS scheduler allocate fair share of time to multiple process to get complete.
    * Context switching - process of saving state of currently running process or thread and loading state of next process.
    *
    * MultiThreading - ability to execute multiple thread within single process concurrently., allows single process
    * or application to perform multiple task at same time, improving performance and responsiveness.
    * Package - java.lang, class - Thread class and Runnable interface.
    * JVM can distribute threads across multiple cores allowing parallel execution of threads.
    * Program starts -> Main method - Main Thread.
    * Thread created by user - user thread
    * Daemon thread - thread that runs in background. like garbage collection
    * ## JVM does not wait for daemon thread to finish, but will wait for main and user thread to finish.
    * user can set user thread as daemon thread using setDaemon(true);
    *
    * To create new thread - extend Thread class or implement Runnable interface.
    *
    * Thread class - extend Thread class -> override run() to define code that
    * constitute new thread. -> start() called to initiate new thread.
    *
    * Runnable interface - implements Runnable -> override run() -> create instance to thread
    * by putting instance of class as param -> start() called for thread instance to initiate new thread.
    *
    * States of Thread - getState()
    * 1. NEW - thread created but not started.
    * 2. RUNNABLE - start() called, ready to run, waiting for CPU time
    * 3. RUNNING - when it is executing
    * 4. BLOCKED/WAITING - waiting for resource or for another thread to perform action.
    * 5. TERMINATED - finished execution
    *
    * join() - allow main thread to wait until sub thread complete its execution.
    * When class is already extends another class, we can use Runnable interface , else can use Thread class.
    * e.g., class A extends B implements Runnable{}
    *
    * setPriority(Thread.MIN_PRIORITY) - to set priority between threads
    * interrupt() - to interrupt existing state like sleep, wait, etc.
    * yield() - hints JVM to willingly run another thread.
    *
    * critical section - part of code that is going to be accessed by multiple threads.
    * race condition -  when multiple thread access and start updating critical section together.
    *
    * synchronized method - allow single thread to access method at a time.
    * synchronized block - allow single thread to access block at a time.
    *
    * mutual exclusion - when critical section is not allowed to be accessed by multiple threads simultaneously.
    * drawback of using synchronization -
    * 1. Fairness, 2.one thread can block for longer time, 3.running thread can not be interrupted, 4.Read/Write locking.
    *
    * Locking - in case of synchronized, each thread access critical section and put lock on it to avoid race condition.
    * 2 types - Intrinsic and Explicit
    * Intrinsic - Internal lock (built into every object) , used in case of synchronization.
    * Explicit/Manual - advance locks, can control when to lock/unlock by using Lock class from java.util.concurrent.locks package.
    * 4 methods - lock(), tryLock(), tryLock(waiting time), unlock()
    *
    * Reentrant lock - implements lock interface, If single thread lock critical section, and it again finds another lock instruction,
    * it'll lock it and keep it until total number of locks are not unlocked. (deadlock prevention)
    * and, if we want threads to access critical section in order/fair manner  - use ReentrantLock(true).
    * e.g. private final Lock lock = new ReentrantLock(true);
    *
    * ReadWriteLock() - allows multiple read lock to access critical resource when write lock is not there.
    * e.g. ReadWriteLock lock = new ReentrantReadWriteLock();
    *
    * DeadLock - situation when A thread wait to get access of locked resources by B threads,and vice versa.
    * can be fixed, if we arrange locks for all threads in same order.
    *
    * Inter thread communication - till now, when a section is locked by thread, other thread have to either wait or
    * recheck in interval if section got unlocked by previous thread, leading to CPU wastage., with inter thread communication
    * threads can communicate between them for better CPU utilization.
    * wait() - if shared resource is locked by thread A, other thread wait for it until notified by thread A.
    * notify() - once thread A is done with resource , it will notify other thread B to access resource.
    * notifyAll() - once thread A is done with resource , it will notify all other threads waiting to access resource.
    *
    * Thread Safety - ensures there will be no race condition in case of multiple threads.
    * Thread pool - collection of pre initialized threads, ready to use.
    * helps in resource management, better response time, control over thread count.
    *
    * Executor framework - java.util.concurrent - simplify development of concurrent application by abstracting
    * away many complexities involved in creating and managing threads.
    * helps in - No need of Manual Thread Management, resource management, scalability, Thread reuse, error handling
    * 3 Interfaces -> Executor(Parent), ExecutorService(child), ScheduledExecutorService
    * e.g. ExecutorService executorService = Executors.newFixedThreadPool(3);
    *
    * submit() with runnable and callable -> return future object,
    * shutdown(), awaitTermination(), get(), isDone() , ...
    * Runnable interface -> run() -> void
    * Callable interface -> call() -> generic return type, throws exception in signature
    * invokeAll(Collection[Task]) - to invoke all callable together using thread pool and return list of futures.- *blocks main
    * thread to complete all task.
    * invokeAll(Collection[Task], timeUnit) - to invoke those callable together using thread pool within timeunit
    * and ignore rest.
    * invokeAny - invokes callable using thread pool, return integer of any one callable from given list.
    *
    * ScheduledExecutorService - used in case some task need to run in some interval., extends ExecutorService
    * schedule() - takes callable or runnable along with timeUnit as initial delay.
    * scheduleAtFixedRate() - takes callable or runnable along with timeUnit as initial delay and recurring period.
    * returns scheduled future.
    *
    * Executors.newCachedThreadPool() - create thread in pool based on requirement and adjust dynamically.
    * (used for short tasks or variable load)
    *
    * Instead of using executor framework submit() and holding main thread by using get(), we can use CountDownLatch
    * or CyclicBarrier to handle it more efficiently.
    *
    *
    */


    public static void main(String[] args) throws InterruptedException {
        //System.out.println(Thread.currentThread().getName()); //main

        /*
        Thread class
        World world = new World();
        System.out.println(world.getState());//NEW
        world.start(); //Thread - 0
        System.out.println(world.getState());//RUNNABLE
        Thread.sleep(200); //main thread
        System.out.println(world.getState());//TIMED_WAITING
        world.join();
        System.out.println(world.getState());//TERMINATED
        */

        /*Runnable interface
        Hello hello = new Hello();
        Thread thread = new Thread(hello);
        thread.start()

        Counter counter = new Counter();
        World t1 = new World(counter); //User threads
        World t2 = new World(counter);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch (Exception e){

        }
        System.out.println(counter.getCount()); // used synchronized

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        //t1.interrupt();
        //Thread.yield();
        t1.setDaemon(true);
        t1.start();
        t2.start();
        //Output - Thread-1 Thread-0
        */

        BankAccount bankAccount = new BankAccount();
        Runnable task = () -> bankAccount.withdraw(50);
        Thread t1 = new Thread(task,"Thread 1");
        Thread t2 = new Thread(task,"Thread 2");
        t1.start();
        t2.start();
    }
}
