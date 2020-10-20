package com.test.yg.day201020;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 控制访问资源线程数目
 *
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        // 表明一次只能有两个线程同时在执行
        Semaphore semaphore = new Semaphore(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,5,60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("开始处理线程名: " + Thread.currentThread().getName() + ", at time:" + System.currentTimeMillis());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
    }

}
