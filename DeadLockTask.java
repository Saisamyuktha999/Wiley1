package wiley.multithreading;

public class DeadLockTask 
{
	//creating object references
    public static Object T1 = new Object();
	public static Object T2 = new Object();
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
			//creating runnable
			Runnable r1 = () -> {
			while(true) {
				//instantiating thread t1
				synchronized(T1) {
					try {
						//locking thread t1
						System.out.println(Thread.currentThread().getName()+" has locked T1");
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//waiting to release t1 so that t2 starts
					System.out.println("waiting for T1.....");
					//instantiating thread 2
					synchronized(T2) {
						System.out.println(Thread.currentThread().getName()+" locking T2");
					}
				}
			}
		};
		//creating runnable
		Runnable r2 = () -> {
			while(true) {
				//instantiating thread 2
				synchronized(T2) {
					try {
						//locking of thread 2
						System.out.println(Thread.currentThread().getName()+" has locked T2");
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("waiting for T2.....");

					synchronized(T1) {
						System.out.println(Thread.currentThread().getName()+" locking T1");
					}
				}
			}
		};
		
		//ctrating threads
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		//starting threads
		t1.start();
		t2.start();
		
	}
}

/*
 * public class MyDeadlock {
	static Object o1 = new Object();
	static Object o2 = new Object();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r1 = () -> {
			while(true) {
				synchronized(o1) {
					try {
						System.out.println(Thread.currentThread().getName()+"has locked Object o1");
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(o2) {
						System.out.println(Thread.currentThread().getName()+"locking o2");
					}
				}
			}
		};
		
		Runnable r2 = () -> {
			while(true) {
				synchronized(o2) {
					try {
						System.out.println(Thread.currentThread().getName()+"has locked Object o2");
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(o1) {
						System.out.println(Thread.currentThread().getName()+"locking o1");
					}
				}
			}
		};
		
		new Thread(r1).start();
		new Thread(r2).start();
	}

}
 */
