package com.test.yg.structure;

/**
 * 模拟数组队列,但是数组只能使用一次,浪费资源空间
 *
 */
public class ArrayTest {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.add(1);
        arrayQueue.add(3);
        arrayQueue.add(4);
        arrayQueue.add(5);
        arrayQueue.add(7);
        arrayQueue.add(8);

        arrayQueue.showAll();

        for (int i = 0; i < 6; i++) {
            System.out.printf("当前头部数据%d\n",arrayQueue.get());
        }

    }


}


/**
 * 只模拟简单队列,不考虑循环情况
 *
 */
class ArrayQueue {
    private int maxSize;

    private int front;

    private int rear;

    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = rear = -1;
    }

    public ArrayQueue() {
        this(10);
    }


    public void add(int n){
        if(isFull()){
            return;
        }
        arr[++rear] = n;
    }

    public int get(){
        if(isEmpty()){
            throw new RuntimeException("数组为空");
        }
        return arr[++front];
    }

    public int showHead() {
        if(isEmpty()){
            throw new RuntimeException("数组为空");
        }
        return arr[front];
    }

    public void showAll() {
        if(isEmpty()){
            throw new RuntimeException("数组为空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    private boolean isFull() {
        return (maxSize - 1) == rear;
    }

    private boolean isEmpty() {
        return rear == front;
    }


}