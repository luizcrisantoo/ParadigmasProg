public class ThreadsSimples {
    public static void main(String[] args) {
        Runnable tarefa = () -> {
            System.out.println("Executando na thread: " + Thread.currentThread().getName());
            try { Thread.sleep(500); } catch (InterruptedException e) {}
            System.out.println("Finalizando: " + Thread.currentThread().getName());
        };

        Thread t1 = new Thread(tarefa, "T1");
        Thread t2 = new Thread(tarefa, "T2");
        Thread t3 = new Thread(tarefa, "T3");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Thread principal terminou");
    }
}