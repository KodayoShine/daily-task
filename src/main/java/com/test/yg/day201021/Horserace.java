package com.test.yg.day201021;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * CyclicBarrier的实际例子
 * 赛马例子
 * 通过CyclicBarrier阻塞每轮,达到比赛的目的
 * 每匹马每次随意移动步数,率先达到一定数量,表示成功
 *
 * 参考网站:https://blog.csdn.net/qq_39241239/article/details/87030142
 */
public class Horserace implements Runnable {
    private static List<Horse> horses = new ArrayList<>();

    private static final int FINISH_LINE = 75;

    private static ExecutorService exec = Executors.newCachedThreadPool();

    @Override
    public void run() {
        StringBuilder s = new StringBuilder();
        //打印赛道边界
        for (int i = 0; i < FINISH_LINE; i++) {
            s.append("=");
        }
        System.out.println(s);

        // 打印每匹马的进度
        horses.forEach(horse -> System.out.println(horse.tracks()));

        // 判断马是否达到终点
        for (Horse horse : horses) {
            if (horse.getStep() >= FINISH_LINE) {
                System.out.println(horse.getId() + "won!");
                exec.shutdownNow();
                return;
            }
        }
        //休息指定时间再到下一轮
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println("barrier-action sleep interrupted");
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Horserace());
        for (int i = 0; i < 7; i++) {
            Horse horse = new Horse(cyclicBarrier, i + 1);
            horses.add(horse);
            exec.execute(horse);
        }
    }

}

class Horse implements Runnable {

    private CyclicBarrier cyclicBarrier;

    private Integer id;

    private Random random = new Random();

    private Integer step = 0;

    public Horse(CyclicBarrier cyclicBarrier, Integer id) {
        this.cyclicBarrier = cyclicBarrier;
        this.id = id;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                step += random.nextInt(3);
                cyclicBarrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public String tracks() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < getStep(); i++) {
            s.append("*");
        }
        s.append(id);
        return s.toString();
    }

    public int getStep() {
        return step;
    }

    public int getId() {
        return id;
    }
}
