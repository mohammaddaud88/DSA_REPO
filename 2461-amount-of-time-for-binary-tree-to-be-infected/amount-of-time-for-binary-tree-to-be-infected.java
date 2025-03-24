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
    public int amountOfTime(TreeNode root, int start) {
        if(root == null) return 0;
        TreeNode target = findTarget(root,start);
        if(target == null) return 0;
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        parentChildMap(root,parentMap,null);
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.add(target);
        int time =0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean burn = false;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();

                if(curr.left != null && !visited.contains(curr.left)){
                    q.add(curr.left);
                    visited.add(curr.left);
                    burn = true;
                }

                if(curr.right != null && !visited.contains(curr.right)){
                    q.add(curr.right);
                    visited.add(curr.right);
                    burn= true;
                }

                TreeNode parent = parentMap.get(curr);
                if(parent != null && !visited.contains(parent)){
                    q.add(parent);
                    visited.add(parent);
                    burn = true;
                }
            }
            if(burn){
                time++;
            }
        }
        return time;
    }
    public TreeNode findTarget(TreeNode root, int start){
        if(root == null) return root;
        if(root.val == start) return root;
        TreeNode left = findTarget(root.left,start);
        if(left != null){
            return left;
        }
        return findTarget(root.right,start);
    }

    public void parentChildMap(TreeNode root, Map<TreeNode,TreeNode> map, TreeNode parent){
        if(root == null) return;
        map.put(root,parent);
        parentChildMap(root.left,map,root);
        parentChildMap(root.right,map,root);
    }
}