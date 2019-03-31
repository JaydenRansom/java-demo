package com.jayden.threadpool;

import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jayden
 */
public class ExecutorsDemo {

    private static ExecutorService exec = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100), r -> {
        Thread t = new Thread(r);
        t.setName("worker-thread-" + UUID.randomUUID().toString());
        return t;
    }, (r, executor) -> {
        if (!executor.isShutdown()) {
            try {
                //阻塞等待put操作
                System.err.println("waiting queue is full, putting...");
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    private static AtomicInteger at = new AtomicInteger(0);

    public static void main(String[] args) {
        while (true) {
            exec.submit(() -> {
                System.err.println("Worker" + at.getAndIncrement() + " start.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("Worker end.");
            });
        }
    }
}
