package com.test.yg.thread;

/**
 *
 * 当前任务
 */
public class Task implements Runnable {

    private int i;

    public Task(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("执行当前任务的线程是：" + Thread.currentThread().getName());
        System.out.println("我是任务:" + i + "我在执行...");
    }
}
