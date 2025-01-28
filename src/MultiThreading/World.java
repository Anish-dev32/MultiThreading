package MultiThreading;

public class World extends Thread{
    private Counter counter;

    World(Counter counter){
        this.counter = counter;
    }
    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName());
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

//        for(int i=0; i<1000; i++){
//            System.out.println(Thread.currentThread().getName()+" : "+i);
//        }

        for(int i=0; i<1000; i++){
            counter.increment();
        }
    }
}
