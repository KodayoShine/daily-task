package com.test.yg.day201023;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子整形类
 */
public class AtomicIntegerABA {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        new Thread(() -> {
            int a = atomicInteger.get();
            System.out.println("当前线程:" + Thread.currentThread().getName() + ", 数值为:" + a);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean b = atomicInteger.compareAndSet(a, 2);
            System.out.println("当前线程:" + Thread.currentThread().getName() + ", 数值为:" + atomicInteger.get() + ", 是否修改成功:" + b);

        }, "主线程").start();


        new Thread(() -> {
            atomicInteger.incrementAndGet();
            System.out.println("当前线程:" + Thread.currentThread().getName() + ", 数值为:" + atomicInteger.get());
            atomicInteger.decrementAndGet();
            System.out.println("当前线程:" + Thread.currentThread().getName() + ", 数值为:" + atomicInteger.get());

        }, "修改线程").start();


    }


}
