package synchronousop;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        Thread worker1 = new Thread(new Worker(latch, "Worker 1"));
        Thread worker2 = new Thread(new Worker(latch, "Worker 2"));
        Thread worker3 = new Thread(new Worker(latch, "Worker 3"));
        worker1.start();
        worker2.start();
        worker3.start();

        try {
            System.out.println("Main thread is waiting for workers to finish...");
            latch.await();
            System.out.println("All workers have finished. Main thread continues...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Worker implements Runnable {
    private CountDownLatch latch;
    private String name;
    public Worker(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is doing work.");
            Thread.sleep((long) (Math.random() * 2000));
            System.out.println(name + " has finished work.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }
}