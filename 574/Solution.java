//TLE
public class Solution {
    /**
     * @param grid: a 2D grid
     * @return: An integer
     */
    static final int INF = Integer.MAX_VALUE;
    public int shortestDistance(int[][] grid) {
        // write your code here
        int n = grid.length, m = grid[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) list.add(new int[]{i, j});
            }
        }
        int res = INF;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    int temp = 0;
                    for (int k = 0; k < list.size(); k++) {
                        temp += Math.abs(list.get(k)[0] - i) + Math.abs(list.get(k)[1] - j);
                    }
                    res = Math.min(res, temp);
                }
            }
        }
        return res;
    }
}
