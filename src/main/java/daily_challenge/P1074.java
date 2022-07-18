package daily_challenge;

import java.util.HashMap;
import java.util.Map;

public class P1074 {

    class Solution {
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int r = matrix.length;
            int c = matrix[0].length;

            int[][] ps = new int[r + 1][c + 1];
            for(int i = 1; i <= r; i++) {
                for(int j = 1; j <= c; j++) {
                    ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }

            int count = 0;
            int currSum;
            Map<Integer, Integer> h = new HashMap<>();

            for(int r1 = 1; r1 <= r; r1++) {
                for(int r2 = r1; r2 <= r; r2++) {
                    h.clear();
                    h.put(0, 1);
                    for(int col = 1; col <= c; col++) {
                        currSum = ps[r2][col] - ps[r1 - 1][col];
                        count += h.getOrDefault(currSum - target, 0);
                        h.put(currSum, h.getOrDefault(currSum, 0) + 1);
                    }
                }
            }

            return count;
        }
    }

    class Solution1 {
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int res = 0;

            // traverse upper boundary
            for (int top = 0; top < m; top++) {

                // for each upper boundary, we have a prefix sum array
                int[] sum = new int[n];

                // traverse lower boundary
                for (int bottom = top; bottom < m; bottom++) {

                    // count the prefix sum for each column
                    for (int col = 0; col < n; col++) {
                        sum[col] += matrix[bottom][col];
                    }

                    // traverse left and right boundary
                    for (int left = 0; left < n; left++) {
                        int cnt = 0;
                        for (int right = left; right < n; right++) {
                            cnt += sum[right];
                            if (cnt == target) res++;
                        }
                    }
                }
            }
            return res;
        }
    }
}
