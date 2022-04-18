/* 
since the distance on row, col could be consider separate, we could first preprocess
how many house in each row and col.
And then we could calculate the cost in each row and column 
And then add them together should be the final distance
O(n * m)
*/
public class Solution {
    /**
     * @param grid: a 2D grid
     * @return: An integer
     */
    static final int INF = Integer.MAX_VALUE;
    public int shortestDistance(int[][] grid) {
        // write your code here
        int n = grid.length, m = grid[0].length;
        int[] count_x = new int[n];
        int[] count_y = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count_x[i]++;
                    count_y[j]++;
                }
            }
        }
        int[] cost_x = new int[n];
        int[] cost_y = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost_x[i] += count_x[j] * Math.abs(i - j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                cost_y[i] += count_y[j] * Math.abs(i - j);
            }
        }
        int res = INF;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    res = Math.min(res, cost_x[i] + cost_y[j]);
                }
            }
        }
        return res;
    }
}
