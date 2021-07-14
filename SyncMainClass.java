package wiley.miniproject.pck;

public class SyncMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Process process = new Process();
		//create thread 1
		Thread t1 = new Thread(process,"t1");
		//strat 1
		t1.start();
		//create thread 2
		Thread t2=new Thread(process,"t2");
		//start thread 2
		t2.start();
		//create thread 2
		Thread t3=new Thread(process,"t3");
		//start thread 2
		t3.start();
		Thread t4=new Thread(process,"t4");
		//start thread 2
		t4.start();
		Thread t5=new Thread(process,"t5");
		//start thread 2
		t5.start();
		Thread t6=new Thread(process,"t6");
		//start thread 2
		t6.start();
		Thread t7=new Thread(process,"t7");
		//start thread 2
		t7.start();
		
	}

}
class Process implements Runnable
{
	private int counter=0;

	public int getCounter() {
		return counter;
	}
	public void increment() {
		try {
			Thread.sleep(100);
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
			
		}
		//increment
		counter++;
	}
	public void decrement() {
		counter--;
	}
	public synchronized void run() {
		//to resolve the race condition we will synchronized the block 
		synchronized(this){
		//this is a critical section
		//only single thread can enter at a time
		//increment the counter
		this.increment();
		}
		System.out.println(" "+Thread.currentThread().getName()+" "+this.getCounter());
		
		//decrement the counter
		//this.decrement();
		//System.out.println(" "+Thread.currentThread().getName()+" "+this.getCounter());

	}
	
}



/*
 * t1=> counter = 0
 * t2=> counter = 1 / 2 /3
 * decrement 1 / 2
*/