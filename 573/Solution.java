public class Solution {
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    Queue<PI> queue;
    int dist[][], cnt[][], n, m;
    boolean v[][];
    public int shortestDistance(int[][] grid) {
        n = grid.length; m = grid[0].length;
        dist = new int[n][m]; cnt = new int[n][m];
        v = new boolean[n][m];
        queue = new LinkedList<>();
        int house = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    house++;
                    bfs(i, j, grid);             
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && cnt[i][j] == house) res = Math.min(res, dist[i][j]);
            }
        }
        if (res == Integer.MAX_VALUE) res = -1;
        return res;
    }

    void bfs(int i, int j, int[][] grid) {
        for (var arr: v) Arrays.fill(arr, false);
        v[i][j] = true;
        queue.add(new PI(i, j));
        int dt = 0;
        while (!queue.isEmpty()) {
            int l = queue.size();
            while (l-- > 0) {
                PI first = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int x = first.x + dx[k], y = first.y + dy[k];
                    if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != 0 || v[x][y]) continue;
                    dist[x][y] += dt + 1;
                    cnt[x][y]++; 
                    v[x][y] = true;
                    queue.add(new PI(x, y));
                }
            }
            dt++;
        }   
    }
}

class PI{
    int x, y;
    PI(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
