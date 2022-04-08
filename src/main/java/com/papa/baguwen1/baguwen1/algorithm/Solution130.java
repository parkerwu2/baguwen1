package com.papa.baguwen1.baguwen1.algorithm;

public class Solution130 {
    private int m;
    private int n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        //处理最左最右列
        for (int i = 0; i < m; i++){
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        //处理最上最下行
        for (int i = 1; i < n; i++){
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board, int x, int y){
        if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || board[x][y] != 'O'){
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }

    public static void main(String[] args) {
        char [][] board = new char[][]{
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}
        };
        int m = board.length;
        int n = board[0].length;
        new Solution130().solve(board);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
