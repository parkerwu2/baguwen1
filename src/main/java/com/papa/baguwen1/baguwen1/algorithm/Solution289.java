package com.papa.baguwen1.baguwen1.algorithm;

//289. 生命游戏
public class Solution289 {
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        int[][] cp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                cp[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int r = one(cp, i, j);
                board[i][j] = r;
            }
        }
    }
    private int findLive(int[][] board, int i, int j){
        int cnt = 0;
        cnt += findOneDirection(board, i - 1, j - 1);
        cnt += findOneDirection(board, i - 1, j);
        cnt += findOneDirection(board, i - 1, j + 1);
        cnt += findOneDirection(board, i, j - 1);
        cnt += findOneDirection(board, i, j + 1);
        cnt += findOneDirection(board, i + 1, j - 1);
        cnt += findOneDirection(board, i + 1, j);
        cnt += findOneDirection(board, i + 1, j + 1);
        return cnt;
    }
    private int findOneDirection(int[][] board, int i, int j){
        if (i < 0 || j < 0 || i >= m || j >= n){
            return 0;
        }
        if (board[i][j] == 1){
            return 1;
        } else {
            return 0;
        }
    }
    private int one(int[][] board, int i, int j){
        if (board[i][j] == 1){
            int live = findLive(board, i, j);
            if (live < 2 || live > 3){
                return 0;
            } else {
                return 1;
            }
        } else {
            int live = findLive(board, i, j);
            if (live == 3){
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        new Solution289().gameOfLife(board);
    }
}
