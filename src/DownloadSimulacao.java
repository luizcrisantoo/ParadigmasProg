import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadSimulacao {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 8; i++) {
            int arquivo = i;
            pool.submit(() -> {
                System.out.println("Iniciando download do arquivo " + arquivo + " - " + Thread.currentThread().getName());
                try { Thread.sleep(1500); } catch (InterruptedException e) {}
                System.out.println("Download concluído: arquivo " + arquivo);
            });
        }

        pool.shutdown();
    }
}