package com.test.yg.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * <p>
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 * <p>
 * <p>
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 */
public class LeetCode341 {

    class NestedIterator implements Iterator<Integer> {

        private Queue<Integer> list = new LinkedBlockingQueue<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            add(nestedList);
        }

        public void add(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    list.offer(nestedInteger.getInteger());
                } else {
                    add(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return list.poll();
        }

        @Override
        public boolean hasNext() {
            return list.peek() != null;
        }
    }

    interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

}
