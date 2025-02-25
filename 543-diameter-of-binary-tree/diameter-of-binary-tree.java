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
    // method - 2
    int ans=0;
    int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftTree = solve(root.left);
        int rightTree = solve(root.right);
        // ans = Math.max(Math.max(leftTree,rightTree),leftTree+rightTree);
        ans= Math.max((leftTree + rightTree),ans);
        return Math.max(leftTree,rightTree)+1;
    }

    // method - 1
    // return height and diameter of the subtree
    // int [] solve(TreeNode root){
    //     if(root == null){
    //         return new int[]{0,0} ;
    //     }
    //     if(root.left == null && root.right == null){
    //         return new int[]{1,0};
    //     }

    //     int [] left = solve(root.left);
    //     int [] right = solve(root.right);
    //     int ans[]=new int[2];
    //     ans[0]=Math.max(left[0],right[0])+1;
    //     ans[1]= Math.max(Math.max(left[1],right[1]),left[0]+right[0]);
    //     return ans;
    // }
    public int diameterOfBinaryTree(TreeNode root) {
        // return solve(root)[1];
        solve(root);
        return ans;
    }

}