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
    class Pair{
        int val;
        TreeNode node;
        public Pair(int val, TreeNode node){
            this.val = val;
            this.node = node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1,root));
        int maxWidth=1;
        int first=0, last=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair curr = q.poll();
                if(i==0){
                    first = curr.val;
                }
                if(i==size-1){
                    last = curr.val;
                }
                if(curr.node.left != null){
                    q.add(new Pair(curr.val *2,curr.node.left));
                }
                if(curr.node.right != null){
                    q.add(new Pair(curr.val * 2 +1, curr.node.right));
                }
            }
            maxWidth = Math.max(maxWidth, last - first +1);
        }
        return maxWidth;
    }
}