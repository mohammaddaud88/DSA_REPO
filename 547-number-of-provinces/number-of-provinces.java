class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean vis[] = new boolean[n];
        int ans = 0;
        for (int i = 0; i <n; i++) {
            if(vis[i] == false){
            ans++;
            dfs(i,vis,isConnected);
            }
        }
        return ans;
    }

    void dfs(int s, boolean[] vis, int[][] graph) {
        vis[s] = true;
        for (int i = 0; i < graph[s].length; i++) {
            if (graph[s][i]>0 && vis[i] == false) {
                dfs(i, vis, graph);
            }
        }

    }
}