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
        int index;
        TreeNode node;
        public Pair(int index,TreeNode node){
            
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Map<Integer,List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int currLvl=1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                addEle(map,currLvl,curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            currLvl++;
        }
        for(List<Integer> l:map.values()){
            list.add(l.get(l.size()-1));
        }
        return list;
    }
    public void addEle(Map<Integer,List<Integer>> map,int index, int val){
        map.putIfAbsent(index,new ArrayList<Integer>());
        map.get(index).add(val);
    }
    
}