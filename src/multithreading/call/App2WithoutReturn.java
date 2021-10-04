package multithreading.call;

import java.util.Random;
import java.util.concurrent.*;

public class App2WithoutReturn {
    //future without return
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<?> future = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                //can throw exception as well
                System.out.println("Starting....");
                Random random = new Random();
                int millis = random.nextInt(4000);
                Thread.sleep(millis);
                System.out.println("Finished");
                return null;
            }
        });
        executorService.shutdown();
        try {
            System.out.println("Returned values is: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
