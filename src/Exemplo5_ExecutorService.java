import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Exemplo5_ExecutorService {
    public static void main(String[] args) {
        int tarefas = 1000;
        ExecutorService pool = Executors.newFixedThreadPool(8);
        AtomicInteger contador = new AtomicInteger();

        // envia tarefas para o pool
        for (int i = 0; i < tarefas; i++) {
            pool.submit(() -> contador.incrementAndGet());
        }

        // impede novas tarefas
        pool.shutdown();
        try {
            // espera até 5 segundos pelas tarefas terminarem
            if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Contador final (ExecutorService): " + contador.get());
    }
}
