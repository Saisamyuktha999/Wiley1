package wiley.multithreading;
import java.util.Optional;
import java.util.concurrent.*;

public class FibThreadPool {

	public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        FibCall call = new FibCall();
        Future<String> Future = service.submit(call);
        try{
            if(Future.isDone()){
                String res1 = Future.get();
            }
            System.out.println("Fib series "+Future.get());
        }catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        }
        Future.cancel(true);
        try{
            if(Future.isCancelled()){
                String res1 = Future.get();
            }
            System.out.println("Fib series Ended");
        }catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        }
        service.shutdown();
    }
}
class FibCall implements Callable<String>{

    @Override
    public String call() {
    	int a=0;
    	int b=1;
        StringBuilder response = new StringBuilder();
        for(int i= 0;i< 10;i++){
        	int sum=a+b;
            response.append(a);
            response.append("_");
            a=b;
            b=sum;
        }
        return response.toString();
    }
}