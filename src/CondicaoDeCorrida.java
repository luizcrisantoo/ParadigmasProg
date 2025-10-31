public class CondicaoDeCorrida {
    private static int contador = 0;

    public static void main(String[] args) throws InterruptedException {
        int totalThreads = 1000;
        Thread[] threads = new Thread[totalThreads];

        for (int i = 0; i < totalThreads; i++) {
            threads[i] = new Thread(() -> contador++);
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Valor final: " + contador);
        System.out.println("Esperado: " + totalThreads);
    }
}