package my.satish.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExecuterSingleThreadPoolThreadFactory {

	public static void main(String[] args) {
		//This class will provide new threads with customise name and priority
		ThreadFactory threadFactory = new CustomeThreadFactory("Testing_Thread");
		
		
		ExecutorService executor = Executors.newSingleThreadExecutor(threadFactory);
		
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

class CustomeThreadFactory implements ThreadFactory{

	String threadNamePrefix;
	
	public CustomeThreadFactory(String threadNamePrefix) {
		this.threadNamePrefix = threadNamePrefix;
	}
	
	@Override
	public Thread newThread(Runnable runnable) {
		 Thread thread = new Thread(runnable);
         thread.setName(threadNamePrefix + "-" + thread.getId());
         thread.setPriority(Thread.NORM_PRIORITY);
         thread.setDaemon(false); // Set to true if you want the threads to be daemon threads
         return thread;
	}
	
}
