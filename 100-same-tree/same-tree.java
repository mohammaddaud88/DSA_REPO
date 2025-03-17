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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr1 = q1.poll();
                TreeNode curr2 = q2.poll();
                if (curr1.val != curr2.val) {
                    return false;
                }
                if (curr1.left != null && curr2.left != null) {
                    q1.add(curr1.left);
                    q2.add(curr2.left);
                } else if(curr1.left == null && curr2.left != null){
                    return false;
                } else if(curr1.left != null && curr2.left == null){
                    return false;
                }
                if (curr1.right != null && curr2.right != null) {
                    q1.add(curr1.right);
                    q2.add(curr2.right);
                }else if(curr1.right != null && curr2.right == null){
                    return false;
                }else if(curr1.right == null && curr2.right != null){
                    return false;
                }
            }
        }
        return true;
    }
}