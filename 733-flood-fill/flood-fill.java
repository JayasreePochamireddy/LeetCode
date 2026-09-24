class Solution {
    private void dfs(int[][] image, int sr, int sc, int color, int startColor){
        int n=image.length;    //row
        int m=image[0].length; //col
        //recurrsion in horizontal and vertical directions
        if(sr<0 || sc<0 || sr>= n || sc>= m || image[sr][sc]==color){
            return;
        }
        int existingColor=image[sr][sc];

        if(startColor==existingColor){
            image[sr][sc]=color;  //Flood Fill
        }
        else{
            return;
        }
      // if(image[sr][sc]==color) return;
       dfs(image,sr,sc-1,color,startColor);
       dfs(image,sr,sc+1,color,startColor);
       dfs(image,sr-1,sc,color,startColor);
       dfs(image,sr+1,sc,color,startColor);

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      
      int startColor=image[sr][sc];
      dfs(image,sr,sc,color,startColor);
      return image;
    }
}