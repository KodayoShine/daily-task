package com.test.yg.day201101;

/**
 * 循环队列数组
 */
public class CircleArrayQueueTest {

    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(5);
        circleArray.add(1);
        circleArray.add(2);
        circleArray.add(3);
        circleArray.add(4);
        circleArray.add(5);
        circleArray.showAll();

        int i = circleArray.get();
        System.out.printf("查询当前头部数值%d\n", i);
        circleArray.add(10);
        circleArray.showAll();
    }


}


class CircleArray {

    private int maxSize;

    private int front;

    private int rear;

    private int[] arr;

    public CircleArray() {
        this(10);
    }

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = rear = 0;
    }


    public void add(int n) {
        if (isFull()) {
            System.out.println("满了");
            return;
        }

        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }


    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("空的");
        }
        int a = (++front) % maxSize;
        return arr[a];
    }


    public void showAll() {
        if (isEmpty()) {
            throw new RuntimeException("数组为空");
        }
        for (int i = front; i < front + arrEffectiveSize(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 求出当前数组有效数据
     */
    public int arrEffectiveSize() {
        // 这里需要求出循环队列的长度
        // 那么在循环队列中会出现两种情况
        // rear 大于 front 这种情况: rear - front
        // rear 小于 front  分为两步计算,0 + rear 和 maxSize - front  将这两部分合成-> rear + maxSize - front
        // 再将以上两个步骤合并 (rear + maxSize - front) %maxSize
        return (rear + maxSize - front) % maxSize;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }


}