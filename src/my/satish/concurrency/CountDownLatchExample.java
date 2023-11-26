package my.satish.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	public static void main(String args[]) throws InterruptedException {
        
        CountDownLatch latch = new CountDownLatch(8);
        Worker first = new Worker(1000, latch, "WORKER-1");
        Worker second = new Worker(1000, latch, "WORKER-2");
        Worker third = new Worker(1000, latch, "WORKER-3");
        Worker fourth = new Worker(1000, latch, "WORKER-4");
        
        first.start();
        second.start();
        third.start();
        fourth.start();
        
        // Main thread will wait until all thread finished
        //latch.await();
        
        
        Worker fifth = new Worker(1000, latch, "WORKER-5");
        Worker sixth = new Worker(1000, latch, "WORKER-6");
        Worker seventh = new Worker(1000, latch, "WORKER-7");
        Worker eighth = new Worker(1000, latch, "WORKER-8");
        
        fifth.start();
        sixth.start();
        seventh.start();
        eighth.start();
        
        latch.await();
        
        System.out.println(Thread.currentThread().getName() 
                      + " has finished");

    }

}

class Worker extends Thread {
    private int delay;
    private CountDownLatch latch;

    public Worker(int delay, CountDownLatch latch, String name) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
        	System.out.println("Thread has started ..........");
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(Thread.currentThread().getName() 
                         + " has finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}