/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Deque<TreeNode> q =new ArrayDeque<>();
        q.offer(root);
        //FOR ZIGZAG CREATE A FLAG TRUE
        //boolean flag=true;
        while(!q.isEmpty()){
            int sz=q.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<sz;i++){
                TreeNode temp=q.pop();
                //if(flag) level.add(temp.val);
                //else level.add(0,temp.val);
                level.add(temp.val);
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);

            }
            res.add(0,level);
            //flag=!flag;
        }
        return res;
    }
}