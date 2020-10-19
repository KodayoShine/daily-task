package com.test.yg.day201019;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock 完成三个线程交叉打印问题
 * 有三个线程tA、tB、tC，当i为1时线程tA打印，当i为2时线程B打印，当i为3时线程C打印，并且这三个线程遵循tA唤醒tB，tB唤醒tC，tC唤醒tA的规则。
 *
 */
public class ReentrantLockTest {

    static ReentrantLock lock = new ReentrantLock();
    static Condition conditionA = lock.newCondition();
    static Condition conditionB = lock.newCondition();
    static Condition conditionC = lock.newCondition();
    static volatile int count = 0;

    public static void printA() {
        try{
            lock.lock();

            for (int i = 0; i < 10; i++) {

                while (count % 3 != 0) {
                    conditionA.await();
                }
                System.out.print("A");
                count++;
                conditionB.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public static void printB() {
        try{
            lock.lock();

            for (int i = 0; i < 10; i++) {

                while (count % 3 != 1) {
                    conditionB.await();
                }
                System.out.print("B");
                count++;
                conditionC.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void printC() {
        try{
            lock.lock();

            for (int i = 0; i < 10; i++) {

                while (count % 3 != 2) {
                    conditionC.await();
                }
                System.out.print("C");
                count++;
                conditionA.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        new Thread(()-> printA(),"tA").start();
        new Thread(()-> printB(),"tB").start();
        new Thread(()-> printC(),"tC").start();

        Thread.currentThread().join();
    }

}
