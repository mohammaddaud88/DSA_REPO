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
    private class Pair {
        TreeNode node;
        int index;

        public Pair(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        int currLvl = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                addElement(map, curr.index, currLvl, curr.node.val);

                if (curr.node.left != null) {
                    q.add(new Pair(curr.index - 1, curr.node.left));
                }

                if (curr.node.right != null) {
                    q.add(new Pair(curr.index + 1, curr.node.right));
                }
            }
            currLvl++;
        }

        for(Map<Integer,List<Integer>> innerMap:map.values()){
            List<Integer> list = new ArrayList<>();
            for(List<Integer> l: innerMap.values()){
                Collections.sort(l);
                list.addAll(l);
            }
            lists.add(list);
        }
        return lists;

    }

    public void addElement(Map<Integer, Map<Integer, List<Integer>>> map, int outer, int middle, int value) {
        map.putIfAbsent(outer, new TreeMap<>());
        map.get(outer).putIfAbsent(middle, new ArrayList<>());
        map.get(outer).get(middle).add(value);
    }
}