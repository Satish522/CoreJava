package my.satish.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFixedThreadPool {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Runnable task1 = ()-> {
			System.out.println("Started running one task1 "+ Thread.currentThread().getName());
			if(true) {
				throw new RuntimeException();
			}
			System.out.println("Just checking");
		};
		
		Runnable task2 = ()-> {
			System.out.println("Started running one task2 "+ Thread.currentThread().getName());
			 
			if(true) {
				throw new RuntimeException();
			}
			System.out.println("Just checking");
			
		};
		
		for(int i=0; i<5; i++) {
			executor.execute(task1);
			executor.execute(task2);
		}

	}

}
