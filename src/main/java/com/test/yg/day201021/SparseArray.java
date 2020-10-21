package com.test.yg.day201021;

/**
 * 稀疏数组
 * 用于在很多没有意义数据的情况,可以使用稀疏数组,减少数据数量
 * <p>
 * 举例:
 * 比如五子棋中,使用二维数组,在保存的时候,会有大量无子的存在,在数组中额外占用数据空间
 * 就可以通过稀疏数组的形式,减少数据量
 */
public class SparseArray {

    public static void main(String[] args) {
        Checkerboard checkerboard = new Checkerboard();
        checkerboard.print();

        System.out.println("====================");
        checkerboard.add(1, 2, Piece.black);
        checkerboard.add(2, 3, Piece.white);
        checkerboard.add(4, 5, Piece.white);
        checkerboard.print();
        System.out.println("====================");
        int[][] sparseArr = checkerboard.toSparseArray();
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
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
    public int[][] toSparseArray() {
        // 统计当前棋盘已有棋子数量
        int sum = 0;
        for (int i = 0; i < traverse; i++) {
            for (int j = 0; j < vertical; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 创建稀疏数组
        int sparesArr[][] = new int[sum + 1][3];
        sparesArr[0][0] = traverse;
        sparesArr[0][1] = vertical;
        sparesArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < traverse; i++) {
            for (int j = 0; j < vertical; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparesArr[count][0] = i;
                    sparesArr[count][1] = j;
                    sparesArr[count][2] = chessArr[i][j];
                }
            }
        }

        return sparesArr;
    }

}
