package com.jayden.threadpool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jayden
 */
public class BlockedDemo {

    private static BlockedThreadPool blockedExec = BlockedThreadPool.createBlockedThreadPool(10, "test-thread-pool");

    private static AtomicInteger at = new AtomicInteger(0);

    public static void main(String[] args) {
        while (true) {
            blockedExec.submit(() -> {
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
