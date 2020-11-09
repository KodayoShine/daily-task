package com.test.yg.day201108;

public class Test {


    public static void main(String[] args) {
        EasyThreadPoolExecutor pool = new EasyThreadPoolExecutor(1, 10, 0);
        for (int i = 0; i < 5; i++) {
            pool.execute(new Task(i));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // pool.shutdown();
    }

}
