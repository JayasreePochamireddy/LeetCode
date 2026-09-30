class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        //edge case
        if(n==1 && grid[0][0]==0) return 1; 
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,1});
        
        //mark visited
        grid[0][0]=1;
        
        //8-directions
        int[][] dir = {{-1,-1},{-1,0},{-1,+1},{0,-1},
                        {0,+1},{+1,-1},{+1,0},{+1,+1} };
        
        //process the Queue
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] temp = q.poll();
                int x = temp[0];
                int y = temp[1];
                int path = temp[2];
                
                //check in 8-directions
                for(int[] d: dir){
                    int r = x+d[0];
                    int c = y+d[1];
                    if(r<0 || c<0 || r>=n || c>=n ) continue;
                    
                    if(grid[r][c]==0){
                        q.offer(new int[]{r,c, path+1});
                        grid[r][c]=1;
                        if(r==(n-1) && c==(n-1)) return path+1;
                    }
                    if(grid[r][c]==1) continue;
                }
            }
        }
        return -1;
    }
}
