package com.papa.baguwen1.baguwen1.algorithm;

import java.util.HashSet;
import java.util.Set;

//73. 矩阵置零
public class Solution73 {
    public void setZeroes(int[][] matrix) {
        int len = matrix.length;
        int col = matrix[0].length;
        Set<Integer> lenset = new HashSet<>();//跟这个0同行
        Set<Integer> colset = new HashSet<>(); //跟这个0同列
        for (int i = 0; i < len; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == 0){
                    lenset.add(i);
                    colset.add(j);
                }
            }
        }
        for (int i = 0; i < len; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == 0){
                    continue;
                }
                if (lenset.contains(i) || colset.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,0,7,8},
                {0,10,11,12},
                {13,14,15,0}
        };
        new Solution73().setZeroes(matrix);
        int len = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < len; i++){
            for (int j = 0; j < col; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
