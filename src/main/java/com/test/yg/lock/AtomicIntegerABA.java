package com.test.yg.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 原子整数型类ABA问题的出现原因
 * <p>
 * 另一个线程修改的数据的过程,对于主线程来说 没有感知,无法察觉到数据的变化
 * 但是在主线程中,数据虽然没有发生变化,但不代表没有进行过任何操作
 * <p>
 * 解决方法:
 * 使用乐观锁的概念,对每次数据添加版本号,可以处理ABA的问题出现
 */
public class AtomicIntegerABA {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    private static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(1, 0);

    public static void main(String[] args) {
        //ABA();

        solveABA();
    }

    private static void solveABA() {
        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            System.out.println("当前线程:" + Thread.currentThread().getName() + ", 数值为:" + stampedReference.getReference() + ", 版本号: " + stamp);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = stampedReference.compareAndSet(1, 2, stamp, stamp + 1);
            System.out.println("当前线程:" + Thread.currentThread().getName() + ", 数值为:" + atomicInteger.get() + ", 版本号: " + stampedReference.getStamp() + ", 是否修改成功:" + b);

        }, "主线程").start();


        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            stampedReference.compareAndSet(1,2, stamp, stamp + 1);
            System.out.println("当前线程:" + Thread.currentThread().getName() + ", 数值为:" + stampedReference.getReference() + ", 版本号: " + stamp);

            stamp = stampedReference.getStamp();
            stampedReference.compareAndSet(2,1, stamp, stamp + 1);
            System.out.println("当前线程:" + Thread.currentThread().getName() + ", 数值为:" + stampedReference.getReference() + ", 版本号: " + stamp);

        }, "修改线程").start();


    }

    private static void ABA() {
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
