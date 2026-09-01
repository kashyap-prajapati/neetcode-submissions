class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        Queue<Pair<Integer, Integer>> pq = new LinkedList<>();
        Queue<Pair<Integer, Integer>> aq = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            pq.add(new Pair<>(i, 0));
        }
        for (int j = 0; j < n; j++) {
            pq.add(new Pair<>(0, j));
        }

        for (int i = 0; i < m; i++) {
            aq.add(new Pair<>(i, n - 1));
        }
        for (int j = 0; j < n; j++) {
            aq.add(new Pair<>(m - 1, j));
        }

        int[][] visiteda = new int[m][n];
        int[][] visitedp = new int[m][n];

        bfs(heights, m, n, visiteda, aq);
        bfs(heights, m, n, visitedp, pq);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visiteda[i][j] == 1 && visitedp[i][j] == 1) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    public void bfs(int[][] heights, int m, int n, int[][] visited, Queue<Pair<Integer, Integer>> q) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            int i = p.getKey();
            int j = p.getValue();

            if (visited[i][j] == 1) continue;
            visited[i][j] = 1;

            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];

                if (x < 0 || y < 0 || x >= m || y >= n) continue;

                if (heights[x][y] < heights[i][j]) continue;

                 if (visited[x][y] == 0) {
                    q.offer(new Pair<>(x, y));
                }
            }
        }
    }
}
