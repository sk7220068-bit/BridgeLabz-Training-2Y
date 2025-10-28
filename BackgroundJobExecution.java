public class BackgroundJobExecution {
    public static void main(String[] args) {
        // Define a Runnable task
        Runnable backgroundTask = () -> {
            System.out.println("Background job started...");
            try {
                Thread.sleep(2000); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Background job completed!");
        };

        // Execute asynchronously using a new Thread
        Thread thread = new Thread(backgroundTask);
        thread.start();

        System.out.println("Main thread continues running...");
    }
}
