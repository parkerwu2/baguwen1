package com.papa.baguwen1.baguwen1.algorithm;

//200. 岛屿数量
public class Solution200 {
    boolean [][] visited;
    int m;
    int n;
    int cnt;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                dfs(grid, i, j, false);
            }
        }
        return cnt;
    }
    //isfindnear=true表示相邻节点已经是岛屿统计过了，本次就是找他的邻接节点，不应该重复累加
    void dfs(char[][] grid, int i, int j, boolean isfindnear){
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == '0'){
            return;
        }
        visited[i][j] = true;
        if (!isfindnear) {
            cnt++;
        }
        dfs(grid, i + 1, j, true);
        dfs(grid, i - 1, j, true);
        dfs(grid, i, j + 1, true);
        dfs(grid, i, j - 1, true);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
  {'1','1','0','0','0'},
      {'1','1','0','0','0'},
          {'0','0','1','0','0'},
              {'0','0','0','1','1'}};
        System.out.println(new Solution200().numIslands(grid));
    }
}
