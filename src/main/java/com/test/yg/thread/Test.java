package com.test.yg.thread;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

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

        HashMap map = new HashMap();
        map.put("a", "b");
        map.size();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("a", "b");
        // concurrentHashMap.get();
    }

}
