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
    int ans =Integer.MIN_VALUE;
    int findMax(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSum = findMax(root.left);
        int rightSum = findMax(root.right);
        ans =  Math.max(leftSum+rightSum + root.val, ans);
        return Math.max(Math.max(leftSum,rightSum)+root.val,0);
    }
    public int maxPathSum(TreeNode root) {
        ans=root.val;
        findMax(root);
        return ans;
    }
}