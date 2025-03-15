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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int currLvl = 0;
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            lists.add(list);
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                lists.get(currLvl).add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            currLvl++;
        }
        return lists;
    }
}