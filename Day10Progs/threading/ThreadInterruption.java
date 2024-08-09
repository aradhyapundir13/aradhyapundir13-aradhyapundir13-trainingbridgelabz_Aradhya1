package threading;

public class ThreadInterruption {
    public static void main(String[] args) {
        Runnable longRunningTask = () -> {
            System.out.println("Task started.");
            try {
                for (int i = 0; i < 10; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Task was interrupted.");
                        return;
                    }
                    Thread.sleep(1000);
                    System.out.println("Task is working... " + (i + 1));
                }
            } catch (InterruptedException e) {
                System.out.println("Task was interrupted during sleep.");
                Thread.currentThread().interrupt();
            }
            System.out.println("Task completed.");
        };
        Thread taskThread = new Thread(longRunningTask);
        taskThread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread interrupts the task thread.");
        taskThread.interrupt();
    }
}