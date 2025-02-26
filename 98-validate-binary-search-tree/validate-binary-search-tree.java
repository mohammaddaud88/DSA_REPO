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
    public boolean isValidBST(TreeNode root) {
       return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    boolean isValid(TreeNode root, long lowerLim, long upperLim){
        if(root == null){
            return true;
        }
        if(root.val <= lowerLim || root.val >= upperLim){
            return false;
        }
        boolean checkLeft = isValid(root.left,lowerLim,root.val);
        boolean checkRight = isValid(root.right,root.val,upperLim);
        return checkLeft && checkRight;
    }
}