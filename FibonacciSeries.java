package wiley.miniproject.pck;
public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FibonaaciSer fb=new FibonaaciSer();
		//		Fibo fb=new Fibo(7);
		//		Thread t1=new Thread(fb);
		//	//	FibonnaciSeriesDemo fb1=new FibonnaciSeriesDemo(7);
		//		t1.start();
		Fib f=new Fib(8);
		f.start();
		//fb1.start();
		//	fb1.start();
	}

}
class Fibo implements Runnable{
	public int n=0,sum=0,first=0,second=1;
	public Fibo(int n) {
	// TODO Auto-generated constructor stub
		this.n=n;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print(first+"+"+second);
		sum=first+second;
		System.out.print("+"+sum);
		for(int i=3;i<n;i++) {
			first=second;
			second=sum;
			sum=first+second;
			System.out.print("+"+sum);
		}
		first=second;
		second=sum;
		sum=first+second;
		System.out.print("="+sum);
				
		//	System.out.println("hello");
	}

}
class Fib extends Thread{
	public int n=0,sum=0,first=0,second=1,first1=0,second1=1,sum1=0;
	//int arr[];
	int arr[]=new int[10];
	public Fib(int n) {
		// TODO Auto-generated constructor stub
		this.n=n;
	}
	public void run() {
		System.out.print(first+"+"+second);
		sum=first+second;
		arr[0]=sum;
		System.out.print("+"+sum);
		for(int i=3;i<n;i++) {
		
			first=second;
			second=sum;
			sum=first+second;
			System.out.print("+"+sum);
			arr[i-2]=sum;
		}
		first=second;
		second=sum;
		sum=first+second;
		System.out.println("="+sum);
		// TODO Auto-generated method stub
		System.out.print(first1+"+"+second1);
		sum1=first1+second1;
		System.out.println("="+sum1);
		for(int i=3;i<=n;i++) {
		//System.out.println(first);
			first1=sum1;
			second1=arr[i-3];
			System.out.print(first1+"+"+second1);
			sum1=first1+second1;
			System.out.println("="+sum1);

		}
	}
}

