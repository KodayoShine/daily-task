package com.test.yg.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，
 * 根据smalls中的每一个较短字符串，对big进行搜索。
 * 输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 */
public class LeetCode1717 {

    List<List<Integer>> resList = new ArrayList();

    public int[][] multiSearch(String big, String[] smalls) {
        Trie trie = new Trie(big);
        int n = smalls.length;
        for (int i = 0; i < n; i++) {
            trie.insert(smalls[i], i);
            resList.add(new ArrayList<>());
        }

        int len = big.length();
        for (int i = 0; i < len; i++) {
            trie.search(i, len);
        }

        int[][] res = new int[n][];
        int resI = 0;
        for (List<Integer> list : resList) {
            int[] tmp = new int[list.size()];
            int i = 0;
            for (int num : list) {
                tmp[i++] = num;
            }
            res[resI++] = tmp;
        }
        return res;
    }

    class Trie {
        char[] big;
        TrieNode root;

        Trie(String big) {
            this.big = big.toCharArray();
            root = new TrieNode();
        }

        public void insert(String word, int position) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) {
                    cur.children[i] = new TrieNode();
                }
                cur = cur.children[i];
            }
            cur.position = position;
        }

        public void search(int start, int end) {
            TrieNode cur = root;
            for (int i = start; i < end; i++) {
                int j = big[i] - 'a';
                if (cur.children[j] == null) {
                    return;
                }
                cur = cur.children[j];
                if (cur.position != -1) {
                    resList.get(cur.position).add(start);
                }
            }
        }

        class TrieNode {
            int position = -1;
            TrieNode[] children = new TrieNode[26];
        }
    }

}
