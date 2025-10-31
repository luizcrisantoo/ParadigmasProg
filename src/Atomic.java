import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger contador = new AtomicInteger(0);
        int totalThreads = 1000;
        Thread[] threads = new Thread[totalThreads];

        for (int i = 0; i < totalThreads; i++) {
            threads[i] = new Thread(contador::incrementAndGet);
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Valor final com AtomicInteger: " + contador.get());
    }
}

