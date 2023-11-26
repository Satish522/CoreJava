package my.satish.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(4);
		
		Party p1 = new Party(1000, barrier, "Party1");
		Party p2 = new Party(2000, barrier, "Party2");
		Party p3 = new Party(3000, barrier, "Party3");
		Party p4 = new Party(4000, barrier, "Party4");
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}

}

class Party extends Thread{
	
	int duration;
	CyclicBarrier barrier;
	
	public Party(int duration, CyclicBarrier barrier, String name) {
		super(name);
		this.duration = duration;
		this.barrier = barrier;
	}
	
	public void run() {
		
		try {
			System.out.println("Running Thread name "+Thread.currentThread().getName());
			barrier.await();
			
			System.out.println("Thread has started ..........");
			Thread.sleep(duration);
			System.out.println("Thread has ending");
			
			
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
