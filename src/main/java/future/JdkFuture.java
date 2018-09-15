package future;

import java.util.concurrent.*;

/**
 * @author hum
 */
public class JdkFuture {
    public static void main(String[] args)
            throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(10000L);
                return "I am finished.";
            } catch (InterruptedException e) {
                return "I am Error.";
            }
        });

        while (!future.isDone()) {
            Thread.sleep(10);
        }

        System.out.println(future.get());
        // 不shutdown，之前的线程会一直执行无法退出
        executorService.shutdown();
    }
}
