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
    // return height and diameter of the subtree
    int [] solve(TreeNode root){
        if(root == null){
            return new int[]{0,0} ;
        }
        if(root.left == null && root.right == null){
            return new int[]{1,0};
        }

        int [] left = solve(root.left);
        int [] right = solve(root.right);
        int ans[]=new int[2];
        ans[0]=Math.max(left[0],right[0])+1;
        ans[1]= Math.max(Math.max(left[1],right[1]),left[0]+right[0]);
        return ans;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return solve(root)[1];
    }
}