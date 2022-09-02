package daily_challenge;

import java.lang.reflect.Array;
import java.util.;

public class P200 {
    class Solution {
        public int numIslands(char[][] grid) {
            int numberOfIslands = 0;
            int n = grid.length;
            int m = grid[0].length;
            int di[] = {-1, 1, 0, 0};
            int dj[] = {0, 0, 1, -1};

            Queue<List<Integer>> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        grid[i][j] = '2';
                        numberOfIslands++;
                        List<Integer> newPoint = new ArrayList<>(Arrays.asList(i, j));
                        queue.add(newPoint);

                        while (!queue.isEmpty()) {
                            List<Integer> point = queue.poll();
                            for(int k = 0; k < 4; k++) {
                                int x = point.get(0) + di[k];
                                int y = point.get(1) + dj[k];
                                if(x >= 0 && x < n && y >= 0 && y < m) {
                                    if(grid[x][y] == '1') {
                                        newPoint = new ArrayList<>(Arrays.asList(x, y));
                                        queue.add(newPoint);
                                        grid[x][y] = '2';
                                    }
                                }
                            }
                        }
                    }
                }
            }

            return numberOfIslands;
        }
    }
}
