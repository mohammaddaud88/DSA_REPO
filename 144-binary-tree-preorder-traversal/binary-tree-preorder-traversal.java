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
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        // list = new ArrayList<>();
        // preTra(root);
        if(root == null){
            return list;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty()){
            TreeNode curr = s.pop();
            list.add(curr.val);
            if(curr.right != null){
                s.push(curr.right);
            }
            if(curr.left != null){
                s.push(curr.left);
            }
        }
        return list;
    }
    // public void preTra(TreeNode root){
    //     if(root == null){
    //         return;
    //     }
    //     list.add(root.val);
    //     preTra(root.left);
    //     preTra(root.right);
    // }
}