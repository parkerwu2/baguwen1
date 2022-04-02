package com.papa.baguwen1.baguwen1.algorithm;

import java.util.ArrayList;
import java.util.List;

//54. 螺旋矩阵
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length; //几行
        int n = matrix[0].length; //几列
        if (matrix == null || m == 0 || n == 0){
            return res;
        }
        int left = 0;
        int right = n;
        int up = 0;
        int bottom = m;
        while (left < right && bottom > up){
            for (int i = left; i < right; i++){
                res.add(matrix[up][i]);
            }
            for (int i = up + 1; i < bottom; i++){
                res.add(matrix[i][right - 1]);
            }
            if (left < right - 1 && up < bottom - 1) {
                for (int i = right - 2; i >= left; i--) {
                    res.add(matrix[bottom - 1][i]);
                }
                for (int i = bottom - 2; i > up; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            up++;
            bottom--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> rest = new Solution54().spiralOrder(matrix);
        rest.forEach(a-> System.out.print(a + ","));
    }
}
