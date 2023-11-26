package my.satish.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierInActionExample {

	public static void main(String[] args) {
		Runnable barrierAction = () -> {
			System.out.println("Barrier in action used........"+ Thread.currentThread().getName());
		};
		
		
		CyclicBarrier barrier1 = new CyclicBarrier(2, barrierAction);
		
		CyclicBarrier barrier2 = new CyclicBarrier(2, barrierAction);
		
		
		CyclicBarrierRunnable t1 = new CyclicBarrierRunnable(barrier1, barrier2);
		t1.start();
		CyclicBarrierRunnable t2 = new CyclicBarrierRunnable(barrier1, barrier2);
		t2.start();
		
		

	}

}

class CyclicBarrierRunnable extends Thread{
	
	CyclicBarrier barrier1 ;
	CyclicBarrier barrier2;
	
	public CyclicBarrierRunnable(CyclicBarrier barrier1 , CyclicBarrier barrier2) {
		this.barrier1 = barrier1;
		this.barrier2 = barrier2;
	}
	
	public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +
                                " waiting at barrier 1");
            this.barrier1.await();

            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +
                                " waiting at barrier 2");
            this.barrier2.await();

            System.out.println(Thread.currentThread().getName() +
                                " done!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
