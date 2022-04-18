public class Solution {
    /**
     * @param grid: a 2D grid
     * @return: An integer
     */
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public int shortestDistance(int[][] grid) {
        // write your code here
        int n = grid.length, m = grid[0].length;
        int dist[][] = new int[n][m], cnt[][] = new int[n][m];
        boolean v[][] = new boolean[n][m];
        Queue<PI> queue = new LinkedList<>();
        int house = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    house++;
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
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // System.out.print(dist[i][j] + " ");
                if (grid[i][j] == 0 && cnt[i][j] == house) res = Math.min(res, dist[i][j]);
                
            }
            // System.out.println();
        }
        if (res == Integer.MAX_VALUE) res = -1;
        return res;

    
    }
}

class PI{
    int x, y;
    PI(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
