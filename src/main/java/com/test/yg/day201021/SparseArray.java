package com.test.yg.day201021;

/**
 * 稀疏数组
 * 用于在很多没有意义数据的情况,可以使用稀疏数组,减少数据数量
 *
 * 举例:
 *      比如五子棋中,使用二维数组,在保存的时候,会有大量无子的存在,在数组中额外占用数据空间
 *      就可以通过稀疏数组的形式,减少数据量
 *
 */
public class SparseArray {

    public static void main(String[] args) {
        Checkerboard checkerboard = new Checkerboard();
        checkerboard.print();

    }

}

class Checkerboard {

    int chessArr[][];

    public Checkerboard() {
        init(11,11);
    }
    public Checkerboard(int traverse, int vertical) {
        init(traverse,vertical);
    }

    private void init(int traverse, int vertical) {
        chessArr = new int[traverse][vertical];
    }

    public void print() {
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
    }


}
