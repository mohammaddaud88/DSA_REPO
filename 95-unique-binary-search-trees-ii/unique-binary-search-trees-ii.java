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
    List<TreeNode> list;
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = solve(1,n);
        return ans;
    }

    public List<TreeNode> solve(int l, int r){
        List<TreeNode> ans = new ArrayList<>();
        if(l>r){
            ans.add(null);
            return ans;
        }
        for(int i=l;i<=r;i++){
            List<TreeNode> leftSubTree = solve(l,i-1);
            List<TreeNode> rightSubTree = solve(i+1,r);
            for(int j=0;j<leftSubTree.size();j++){
                for(int k=0;k<rightSubTree.size();k++){
                    TreeNode node = new TreeNode(i);
                    node.left = leftSubTree.get(j);
                    node.right = rightSubTree.get(k);
                    ans.add(node);
                }
            }
        }
        return ans;
    }

}