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
        if(isFull()) {
            System.out.println("满了");
            return;
        }

        arr[rear] = n;
        rear = (rear + 1 ) % maxSize;
    }


    public void showAll() {
        if(isEmpty()){
            throw new RuntimeException("数组为空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }


}