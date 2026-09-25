class Solution {
    private boolean dfs(int[][] grid, int r, int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length) return false;
        if(grid[r][c]==1) return true;
        if(grid[r][c]==2) return true;
        grid[r][c]=2;
        boolean up = dfs( grid,r-1,c);
        boolean down = dfs(grid,r+1,c);
        boolean left = dfs(grid,r,c-1);
        boolean right = dfs(grid,r,c+1);
        return  up && down && left && right; 
    }
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0; //closedIsland
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(grid[r][c]==0){
                     if(dfs(grid,r,c)){
                       count++;
                    }   
                }
            }
        }
        return count;
    }
}