package multithreading.call;

import java.util.Random;
import java.util.concurrent.*;

public class App1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                //can throw exception as well
                System.out.println("Starting....");
                Random random = new Random();
                int millis = random.nextInt(4000);
                Thread.sleep(millis);
                System.out.println("Finished");
                return millis;
            }
        };
        Future<Integer> future = executorService.submit(callable);
        executorService.shutdown();
        try {
//            future.cancel()
//            future.isDone()

            System.out.println("Returned values is: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            //every exception which occurs during future execution is wrapped in the exception
            e.printStackTrace();
        }
    }
}
