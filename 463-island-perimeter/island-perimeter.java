class Solution {
    private int dfs(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return 1;
        if(grid[i][j]==2) return 0; //land no perimeter
        grid[i][j] = 2;
        return dfs(grid,i-1,j) + dfs(grid,i+1,j) + dfs(grid,i,j-1) + dfs(grid,i,j+1);

    }
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int perim=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    perim+=dfs(grid,i,j);
                }
            }
        }
        return perim;
    }
}