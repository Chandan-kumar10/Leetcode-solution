class Solution {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int province = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                province++;

                dfs(i, isConnected, visited);
            }
        }

        return province;
    }

    public void dfs(int city, int[][] isConnected, boolean[] visited) {

        visited[city] = true;

        for (int neighbour = 0; neighbour < isConnected.length; neighbour++) {

            if (isConnected[city][neighbour] == 1
                    && !visited[neighbour]) {

                dfs(neighbour, isConnected, visited);
            }
        }
    }
}