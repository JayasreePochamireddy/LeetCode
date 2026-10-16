class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg=new int[numCourses];
        for(int[] edge: prerequisites){
            int u =edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            indeg[u]++;
        }
        Queue<Integer> q =new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        int count = 0;
        int[] ans = new int[numCourses];
        while(!q.isEmpty()){
            int node = q.poll();
            ans[count]=node;
            count++;
            for(int a: adj.get(node)){
                indeg[a]--;
                if(indeg[a]==0) q.offer(a);
            }
        }
        if(count==numCourses) return ans;
        return new int[]{};
    }
}