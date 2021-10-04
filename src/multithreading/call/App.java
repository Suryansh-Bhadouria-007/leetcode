package multithreading.call;

import java.util.Random;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();
        Future<Integer> future = ex.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                System.out.println("Starting....");
                Random random = new Random();
                Integer millis = random.nextInt(4000);
                Thread.sleep(millis);
                System.out.println("Finished");
                return millis;
            }
        });
        ex.shutdown();
        try {
            System.out.println("Returned values is: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
