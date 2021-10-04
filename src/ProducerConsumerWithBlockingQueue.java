import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerWithBlockingQueue {
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    private void produce() throws InterruptedException {
        Random random = new Random();
        while (true) {
            queue.put(random.nextInt(100));
        }
    }

    private void consume() throws InterruptedException {
        Random random = new Random();
        while (true) {
            Thread.sleep(100);
            if (random.nextInt(10) == 0) {
                Integer take = queue.take();
                System.out.println("Integer taken from queue: " + take + " ; queue size: " + queue.size());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerWithBlockingQueue producerConsumer = new ProducerConsumerWithBlockingQueue();
        Thread producer = new Thread(() -> {
            try {
                producerConsumer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                producerConsumer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();

    }
}
