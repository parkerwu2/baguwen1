package com.papa.baguwen1.baguwen1.algorithm;
//36. 有效的数独
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] line = new int[9][9]; // char[0]表示第0行 char[1]表示第1行 char[0][0]表示第0行1的数量 > 1就返回false
        int[][] collumn = new int[9][9]; // char[0]表示第0列 char[1]表示第1列 char[0][0]表示第0列1的数量 > 1就返回false
        int[][][] sub = new int[3][3][9]; //char[0][0]小9宫格左上角的 char[0][1]表示中上 char[0][0][1]表示左上角9宫格的1的数量  > 1就返回false
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == '.'){
                    continue;
                }
                int num = Integer.valueOf(String.valueOf(board[i][j])) - 1; //因为1在0号位
                if (line[i][num] > 0){
                    return false;
                } else {
                    line[i][num]++;
                }
                if (collumn[j][num] > 0){
                    return false;
                } else {
                    collumn[j][num]++;
                }
                if (sub[i / 3][j / 3][num] > 0){
                    return false;
                } else {
                    sub[i / 3][j / 3][num]++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char a = '3';
        int b = Integer.valueOf(String.valueOf(a));
        System.out.println(b + 1);
    }
}
