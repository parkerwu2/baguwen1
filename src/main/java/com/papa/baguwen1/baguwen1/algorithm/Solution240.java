package com.papa.baguwen1.baguwen1.algorithm;

//240. 搜索二维矩阵 II
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix){
            int ans = find(row, target);
            if (ans == 1){
                return true;
            }
        }
        return false;
    }
    int find(int[] row, int target){
        int i = 0; int j = row.length - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (row[mid] == target) {
                return 1;
            } else if (row[mid] < target){
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }
}
