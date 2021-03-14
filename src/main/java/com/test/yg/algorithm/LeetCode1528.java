package com.test.yg.algorithm;

public class LeetCode1528 {

    /**
     * 1528. 重新排列字符串
     *
     * @param input     字符串
     * @param indices   字符顺序
     * @return
     */
    public String restoreString(String input, int[] indices) {
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0; i < input.length(); ++i){
            sb.setCharAt(indices[i], input.charAt(i));
        }
        return sb.toString();
    }

}
