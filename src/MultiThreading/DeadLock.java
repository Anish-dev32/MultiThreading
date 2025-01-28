package MultiThreading;

class Pen{
    public synchronized void writeWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName()+ " thread is using pen and trying to get paper");
        paper.finishWriting();
    }
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+ " thread finished using pen"+this);
    }
}

class Paper{
    public synchronized void writeWithPaperAndPen(Pen pen){
        System.out.println(Thread.currentThread().getName()+ " thread is using paper and trying to get pen");
        pen.finishWriting();
    }
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+ " thread finished using paper"+this);
    }
}

class Task1 implements Runnable{

    private Pen pen;
    private Paper paper;

    public Task1(Pen pen, Paper paper){
        this.pen = pen;
        this.paper = paper;
    }
    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper); //thread locks pen and try to lock paper
    }
}

class Task2 implements Runnable{

    private Pen pen;
    private Paper paper;

    public Task2(Pen pen, Paper paper){
        this.pen = pen;
        this.paper = paper;
    }
    @Override
    public void run() {
        synchronized (pen){ //fix of Deadlock
            paper.writeWithPaperAndPen(pen); //thread locks paper and try to lock pen
        }
    }
}

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread t1 = new Thread(new Task1(pen, paper));
        Thread t2 = new Thread(new Task2(pen, paper));

        t1.start();
        t2.start();
    }
}
