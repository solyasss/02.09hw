import java.util.Random;

    public class r_string{
    private final int length;
    private final char[] result;
    private final Thread[] threads;

    public r_string(int length) {
        this.length = length;
        this.result = new char[length];
        this.threads = new Thread[length];
    }

    public String generate_string() {
        for (int i = 0; i < length; i++) {
            final int index = i;
            Runnable task = () -> {
                result[index] = r_char();
            };
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("thread interrupted with this message: " + e.getMessage());
            }
        }

        return new String(result);
    }

    private char r_char() {
        Random random = new Random();
        return (char) ('a' + random.nextInt(26));
    }
}
