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
    int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        DFSHeight(root);
        return maxDia;
    }
     private int DFSHeight(TreeNode root){
        if(root==null) return 0;
        int lH = DFSHeight(root.left);
        int rH = DFSHeight(root.right);
        maxDia = Math.max(maxDia,lH+rH);
        return 1+Math.max(lH,rH);
        
    }
}