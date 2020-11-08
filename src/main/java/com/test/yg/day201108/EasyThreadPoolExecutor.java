package com.test.yg.day201108;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 简单的线程池
 */
public class EasyThreadPoolExecutor implements EasyExecutorService {


    private AtomicInteger ctl = new AtomicInteger();

    /**
     * 线程池默认大小
     */
    private static final int defaultPoolSize = 5;

    /**
     * 线程池大小
     */
    private volatile int poolsize;

    /**
     * 线程池最大的大小
     */
    private static final int maxPoolSize = 50;

    /**
     * 默认队列大小
     */
    private static final int defaultQueueSize = 5;

    /**
     * 队列
     */
    private final BlockingQueue<Runnable> workQueue;

    /**
     * 默认超时时间
     */
    private static final long defaultAliveTime = 60L;

    /**
     * 是否允许超时
     */
    private volatile boolean allowThreadTimeOut;

    private volatile long keepAliveTime;


    public EasyThreadPoolExecutor() {
        this(defaultPoolSize, defaultQueueSize, defaultAliveTime);
    }

    public EasyThreadPoolExecutor(int poolSize) {
        this(poolSize, defaultQueueSize, defaultAliveTime);
    }

    public EasyThreadPoolExecutor(int poolSize, int queueSize, long keepAliveTime) {
        if (poolSize <= 0 || poolSize > maxPoolSize) {
            throw new IllegalArgumentException("线程池大小不能<=0");
        }
        this.poolsize = poolSize;
        this.keepAliveTime = keepAliveTime;
        if (keepAliveTime > 0) {
            allowThreadTimeOut = true;
        }
        this.workQueue = new ArrayBlockingQueue<Runnable>(queueSize);
    }


    @Override
    public void execute(Runnable task) {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public int getCorePoolSize() {
        return 0;
    }

    @Override
    public Runnable getTask() {
        return null;
    }
}
