package my.satish.concurrency;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

	public static void main(String[] args) {
		Exchanger exchanger = new Exchanger<>();
		
		ExchangerRunnable ex1 = new ExchangerRunnable(exchanger, "Satish");
		
		ExchangerRunnable ex2 = new ExchangerRunnable(exchanger, "Swapna");
		
		new Thread(ex1, "WORKER-1").start();
		
		new Thread(ex2, "WORKER-2").start();
		
	}

}


class ExchangerRunnable implements Runnable{
	
	Exchanger exchanger;
	String name;
	
	public ExchangerRunnable(Exchanger exchanger, String name) {
		this.exchanger = exchanger;
		this.name = name;
	}
	
	
	public void run() {
		
		System.out.println(Thread.currentThread().getName()+" thread contain object is "+this.name);
		try {
			this.name = (String) this.exchanger.exchange(this.name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+ "Now current thread contain object is "+ this.name);
		
	}
	
}