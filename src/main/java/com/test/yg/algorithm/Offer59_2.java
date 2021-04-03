package com.test.yg.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 *
 */
public class Offer59_2 {

    class MaxQueue {

        private Deque<Integer> nums = new LinkedList<>();
        private Deque<Integer> max = new LinkedList<>();

        public MaxQueue() {

        }

        public int max_value() {
            if(max.isEmpty()){
                return -1;
            }
            return max.peek();
        }

        public void push_back(int value) {
            nums.addLast(value);

            while(!max.isEmpty() && max.peekLast() < value) {
                max.removeLast();
            }
            max.addLast(value);
        }

        public int pop_front() {
            if(nums.isEmpty()) {
                return -1;
            }
            Integer poll = nums.poll();
            if(max.peekFirst().equals(poll)) {
                max.poll();
            }
            return poll;
        }
    }

}
