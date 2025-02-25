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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if(root != null){
            q.offer(root);
        }
        while(q.size()>0){
            int numElementOnSameLevel = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<numElementOnSameLevel;i++){
                TreeNode curr= q.poll();
                list.add(curr.val);
                if(curr.left != null){
                    q.offer(curr.left);
                } 
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}