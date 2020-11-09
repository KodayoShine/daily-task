package com.test.yg.day201108;

import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 简单的线程池
 */
public class EasyThreadPoolExecutor implements EasyExecutorService {

    /**
     * 当前线程数
     */
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

    private volatile boolean isShutDown = false;

    /**
     * Lock
     */
    private final ReentrantLock mainLock = new ReentrantLock();

    /**
     * worker集合
     */
    private final HashSet<Worker> workers = new HashSet<Worker>();


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
        if (task == null) {
            throw new RuntimeException("没有任务");
        }
        if (isShutDown) {
            throw new RuntimeException("当前线程已经中断");
        }

        int c = ctl.get();
        if (c < poolsize) {
            if (addWorker(task, true)) {
                return;
            }
        } else if (workQueue.offer(task)) {

        }

    }

    private boolean addWorker(Runnable task, boolean startNew) {
        if (startNew) {
            ctl.incrementAndGet();
        }
        boolean workerAdded = false;
        boolean workerStarted = false;

        Worker worker = new Worker(task);
        Thread t = worker.thread;
        if(t != null) {
            ReentrantLock mainLock = this.mainLock;
            mainLock.lock();
            try {
                if(!isShutDown) {
                    if(t.isAlive()) {
                        throw new IllegalThreadStateException();
                    }
                    workers.add(worker);
                    workerAdded= true;

                }
            } finally {
                mainLock.unlock();
            }
            if(workerAdded) {
                t.start();
                workerStarted = true;
            }
        }
        return workerStarted;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public int getCorePoolSize() {
        return ctl.get();
    }

    @Override
    public Runnable getTask() throws InterruptedException {
        return allowThreadTimeOut ? workQueue.poll(keepAliveTime, TimeUnit.SECONDS) : workQueue.take();
    }

    private void runWorker(Worker worker) {

    }


    static AtomicInteger name = new AtomicInteger();

    class Worker extends AbstractQueuedSynchronizer implements Runnable {

        private Runnable task;
        private Thread thread;
        volatile long completedTask;

        public Worker(Runnable task) {
            this.task = task;
            this.thread = new Thread(this, "线程名称: " + name.incrementAndGet());
        }


        @Override
        public void run() {
            runWorker(this);
        }
    }


}
