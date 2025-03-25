/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Map<TreeNode,TreeNode> map = new HashMap<>();
        parentChild(root,map,null);
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode tgt = findNode(root,target);
        q.add(tgt);
        visited.add(tgt);
        int count =0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(count == k){
                    ans.add(curr.val);
                    continue;
                }
                if(count > k) return ans;

                if(curr.left != null && !visited.contains(curr.left)){
                    q.add(curr.left);
                    visited.add(curr.left);
                }

                if(curr.right != null && !visited.contains(curr.right)){
                    q.add(curr.right);
                    visited.add(curr.right);
                }

                TreeNode parent = map.get(curr);
                if(parent != null && !visited.contains(parent)){
                    q.add(parent);
                    visited.add(parent);
                }
            }
            count++;
        }
        return ans;
    }
    public TreeNode findNode(TreeNode root, TreeNode target){
        if(root == null) return root;
        if(root == target) return root;
        TreeNode left = findNode(root.left,target);
        if(left != null) return left;
        return findNode(root.right,target);
    }

    public void parentChild(TreeNode root, Map<TreeNode,TreeNode> map, TreeNode parent){
        if(root == null) return;
        map.put(root,parent);
        parentChild(root.left,map,root);
        parentChild(root.right,map,root);
    }
}