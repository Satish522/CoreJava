package my.satish.concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	public static void main(String[] args) {
		
		Semaphore semaphore = new Semaphore(3);
		
		for(int i =0 ; i < 5; i++) {
			Thread t = new Thread(new SemaphoreWorker(semaphore, "WORKER-"+i , i*1000));
			t.start();
		}

	}

}

class SemaphoreWorker implements Runnable{
	
	String name;
	
	Semaphore semaphore;
	
	int duration;
	
	public SemaphoreWorker(Semaphore semaphore, String name, int duration) {
		this.name = name;
		this.semaphore = semaphore;
		this.duration = duration;
	}
	
	public void run() {
		
		 
		try {
			System.out.println(name + " is trying to acquire a permit.");
            semaphore.acquire();
            System.out.println(name + " has acquired a permit.");
            
            // Simulate some work
            Thread.sleep(duration);

            System.out.println(name + " is releasing the permit.");
            semaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
}
