package JianzhiOffer;

import java.util.ArrayList;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
// 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
// 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
public class printMatrix_20 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int start = 0;
        while (2 * start < Math.min(matrix.length, matrix[0].length)) {
            int endX = matrix.length - start - 1;
            int endY = matrix[0].length - start - 1;
            //从左到右打印一行
            for (int j = start; j <= endY; j++) {
                res.add(matrix[start][j]);
            }
            //从上到下打印一行
            if (start < endX) {
                for (int i = start + 1; i <= endX; i++)
                    res.add(matrix[i][endY]);
            }
            //从右到左打印一行
            if (start < endY && start < endX) {
                for (int j = endY - 1; j >= start; j--) {
                    res.add(matrix[endX][j]);
                }

            }
            //从下到上打印一行
            if (start < endX && start < endY) {
                for (int i = endX - 1; i > start; i--) {
                    res.add(matrix[i][start]);

                }

            }
            start++;
        }
        return res;
    }

    public static void main(String[] args) {
        printMatrix_20 it = new printMatrix_20();
//        int[][]arr = {{1}};
        int[][] crr = {{1}, {2}, {3}, {4}, {5}};
        int[][] brr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};
        ArrayList<Integer> res = it.printMatrix(arr);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
