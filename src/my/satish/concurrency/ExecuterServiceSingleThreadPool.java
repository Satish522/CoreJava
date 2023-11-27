package my.satish.concurrency;

 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterServiceSingleThreadPool {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		Runnable task1 = ()-> {
			System.out.println("Started running one task "+ Thread.currentThread().getName());
			if(true) {
				throw new RuntimeException();
			}
			System.out.println("Just checking");
		};
		
		Runnable task2 = ()-> {
			System.out.println("Started running one task "+ Thread.currentThread().getName());
			 
			System.out.println("Just checking");
			
		};
		
		executor.execute(task1);
		executor.execute(task2);
		

	}

}
