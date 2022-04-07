package edu.hubu.mutliThread.fooBar;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: sugar
 * @date: 2022/4/6
 * @description:
 */
public class FromOneToHundred {

    public static Semaphore odd = new Semaphore(1);
    public static Semaphore even = new Semaphore(0);
    public static final AtomicInteger index = new AtomicInteger(1);
    private static volatile boolean start = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    if(!start){
                        return;
                    }
                    odd.acquire();
                    System.out.println("t1:" + index.getAndIncrement());
                    if (index.get() > 100) {
                        start = false;
                        return;
                    }
                    even.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    if(!start){
                        return;
                    }
                    even.acquire();
                    System.out.println("t2:" + index.getAndIncrement());
                    if (index.get() > 100) {
                        start = false;
                        return;
                    }
                    odd.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

    }
}
