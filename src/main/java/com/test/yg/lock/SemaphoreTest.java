package com.test.yg.lock;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 控制访问资源线程数目
 *
 * 使用场景:
 *      主要用于资源访问,服务限流
 *
 * 简单描述工作原理:
 *      AQS中的state进行计数操作,每次调用acquire方法时,则进行CAS原子级的操作,将state做减一操作
 *      当state为0,也就是资源已经全部被占用的时候,多余的线程会进入到AQS的同步队列中,进行阻塞(这里面使用UNSFATE.PARK进行阻塞)等待
 *      当有任意线程释放release的时候,就会调用头部节点的下一个节点,进行唤醒操作
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
