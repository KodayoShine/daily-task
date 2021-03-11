package com.test.yg.structure;

/**
 * 稀疏数组
 * 用于在很多没有意义数据的情况,可以使用稀疏数组,减少数据数量
 * <p>
 * 举例:
 * 比如五子棋中,使用二维数组,在保存的时候,会有大量无子的存在,在数组中额外占用数据空间
 * 就可以通过稀疏数组的形式,减少数据量
 */
public class SparseArray {

    private int sparseArr[][];

    public void init(int traverse, int vertical, int sum) {
        sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = traverse;
        sparseArr[0][1] = vertical;
        sparseArr[0][2] = sum;
    }

    public void add(int count, int traverse, int vertical, int val) {
        sparseArr[count][0] = traverse;
        sparseArr[count][1] = vertical;
        sparseArr[count][2] = val;
    }

    public void print() {
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
    }


    public static void main(String[] args) {
        Checkerboard checkerboard = new Checkerboard();
        checkerboard.print();

        System.out.println("====================");
        checkerboard.add(1, 2, Piece.black);
        checkerboard.add(2, 3, Piece.white);
        checkerboard.add(4, 5, Piece.white);
        checkerboard.print();
        System.out.println("====================");
        SparseArray sparseArr = checkerboard.toSparseArray();
        sparseArr.print();
    }

}

enum Piece {
    black(2), white(1);

    public Integer data;

    public Integer getData() {
        return data;
    }

    Piece(Integer data) {
        this.data = data;
    }
}

class Checkerboard {
    private int traverse;
    private int vertical;

    private int chessArr[][];

    public Checkerboard() {
        this(11, 11);
    }

    public Checkerboard(int traverse, int vertical) {
        this.traverse = traverse;
        this.vertical = vertical;
        init(traverse, vertical);
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

    public void add(int traverse, int vertical, Piece piece) {
        chessArr[traverse][vertical] = piece.getData();
    }

    /**
     * 转换稀疏数组
     *
     * @return
     */
    public SparseArray toSparseArray() {
        // 统计当前棋盘已有棋子数量
        SparseArray sparesArr = initSparseArray();

        int count = 0;
        for (int i = 0; i < traverse; i++) {
            for (int j = 0; j < vertical; j++) {
                if (chessArr[i][j] != 0) {
                    sparesArr.add(++count, i, j, chessArr[i][j]);
                }
            }
        }

        return sparesArr;
    }

    private Integer calculateValidData() {
        int sum = 0;
        for (int i = 0; i < traverse; i++) {
            for (int j = 0; j < vertical; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private SparseArray initSparseArray() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.init(traverse, vertical, calculateValidData());
        return sparseArray;
    }

}
