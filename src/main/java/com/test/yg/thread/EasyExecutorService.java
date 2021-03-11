package com.test.yg.thread;

/**
 * 线程池接口
 *
 */
public interface EasyExecutorService {

    void execute(Runnable task);

    void shutdown();

    int getCorePoolSize();

    Runnable getTask() throws InterruptedException;

}
