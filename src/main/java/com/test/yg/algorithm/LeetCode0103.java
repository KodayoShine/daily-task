package com.test.yg.algorithm;

public class LeetCode0103 {

    /**
     * 面试题 01.03. URL化
     *
     * @param input     输入字符串
     * @param length    真实长度
     * @return
     */
    public String replaceSpaces(String input, int length) {
        return input.substring(0, length).replace(" ", "%20");
    }

}
