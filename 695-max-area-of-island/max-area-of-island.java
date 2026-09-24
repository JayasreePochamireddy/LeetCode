class Solution {
    private int dfs(int[][] grid, int r, int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0) return 0;
        grid[r][c]=0;
        return 1+dfs(grid,r-1,c)+dfs(grid,r+1,c)+dfs(grid,r,c-1)+dfs(grid,r,c+1);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int maxArea=0;
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(grid[r][c]==1){
                    int area=dfs(grid,r,c);
                    maxArea=Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }
}