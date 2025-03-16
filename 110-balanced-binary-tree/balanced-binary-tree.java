/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // int left = leftHeight(root);
        // int right = rightHeight(root);
        // return Math.abs(left - right) <= 1;

        if(height(root) == -1) return false;
        return true;
    }

    public int height(TreeNode root){
        if(root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(leftHeight == -1 || rightHeight == -1) return -1;
        if(Math.abs(leftHeight - rightHeight)>1) return -1;
        return Math.max(leftHeight,rightHeight)+1;
    }

    // public int leftHeight(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int ans = 1 + leftHeight(root.left);
    //     if (root.left != null) {

    //     }
    //     return ans;
    // }

    // public int rightHeight(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int ans = 1 + rightHeight(root.right);
    //     return ans;
    // }
}