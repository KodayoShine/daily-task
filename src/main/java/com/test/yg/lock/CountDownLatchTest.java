package com.test.yg.lock;

import java.util.concurrent.CountDownLatch;

/**
 * 可以使其他线程完成各自任务后再一同执行的工具类
 *
 * 使用场景:
 *      应用程序的主线程在启动框架之前,需要保证负责启动的线程全都完成,再向下执行
 *
 * 简单描述工作原理:
 *      通过state字段进行表示
 *      其余线程调用countDown的时候,都会将state字段使用CAS做减一操作
 *      主线程的await,则会自旋的查看state是否为0
 *
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(() ->{
            try {
                System.out.println("准备洗漱---");
                Thread.sleep(1500);
                System.out.println("洗漱完成---");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }).start();


        new Thread(() ->{
            try {
                System.out.println("准备做饭---");
                Thread.sleep(3000);
                System.out.println("做饭完成---");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }).start();

        countDownLatch.await();
        System.out.println("早上结束啦");

    }

}
