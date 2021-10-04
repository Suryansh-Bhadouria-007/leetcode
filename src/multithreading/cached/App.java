package multithreading.cached;

import java.util.Scanner;

class Processor extends Thread {
    public static volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class App {
    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.start();
        Scanner sc = new Scanner(System.in);
        System.out.println("Hit enter to exit");
        sc.nextLine();
        proc1.shutdown();
    }
}
