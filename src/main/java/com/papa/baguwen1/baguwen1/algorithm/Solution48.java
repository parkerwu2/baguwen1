package com.papa.baguwen1.baguwen1.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

//48. 旋转图像
public class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        Deque<Integer> l = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            for (int j = n - 1; j >= 0; j--){
                l.add(matrix[j][i]);
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = l.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}
