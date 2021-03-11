package com.test.yg.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

/**
 * 栅栏,达到相应线程数量,在最后一个线程达到屏障之后,被拦截的线程同时运行
 * 使先到达屏障点的线程阻塞并等待后面的线程
 * <p>
 * 使用场景:
 * 多线程计算,最终统计结果
 * <p>
 * 简单描述工作原理:
 *      基于ReentrantLock内Condition进行实现的,通过count和Conditon的等待队列,完成操作
 *      每次执行await(),将count数减一,判断是否为0,为0的情况下,唤醒全部等待队列线程,进行下一次的循环
 *      不为0的情况下,将会根据await的重载方法,判断使用定时或者非定时等待
 *
 *
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        IntStream.range(0, 3).forEach(i -> {
            new Thread(()->{
                try {
                    System.out.println("线程名: " + Thread.currentThread().getName() + "准备执行,等待其余线程");
                    cyclicBarrier.await();
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "完成执行任务");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        });


    }


}
