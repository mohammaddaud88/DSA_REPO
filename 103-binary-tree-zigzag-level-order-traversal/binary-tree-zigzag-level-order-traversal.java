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
    List<List<Integer>> lists;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        lists = new ArrayList<>();
        helper(root);
        return lists;
    }
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int currLvl =1;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                list.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                // if(currLvl%2 ==0 && curr.left != null){
                //     q.add(curr.left);
                // } else if(currLvl%2 != 0 && curr.right != null){
                //     q.add(curr.right);
                // }
                // if(currLvl%2 == 0 && curr.right != null){
                //     q.add(curr.right);
                // } else if(currLvl%2 != 0 && curr.left != null){
                //     q.add(curr.left);
                // }
            }
            if(currLvl%2 == 0){
                Collections.reverse(list);
            }
            lists.add(list);
            currLvl++;
        }
    }
}