package daily_challenge;

import java.util.*;

public class P967 {

    class Solution {

        public int[] numsSameConsecDiff(int N, int K) {
            if (N == 1)
                return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

            List<Integer> results = new ArrayList<Integer>();
            for (int num = 1; num < 10; ++num)
                this.DFS(N - 1, num, K, results);

            return results.stream().mapToInt(i->i).toArray();
        }

        protected void DFS(int N, int num, int K, List<Integer> results) {
            if (N == 0) {
                results.add(num);
                return;
            }
            List<Integer> nextDigits = new ArrayList<>();

            Integer tailDigit = num % 10;
            nextDigits.add(tailDigit + K);
            if (K != 0)
                nextDigits.add(tailDigit - K);
            for (Integer nextDigit : nextDigits) {
                if (0 <= nextDigit && nextDigit < 10) {
                    Integer newNum = num * 10 + nextDigit;
                    this.DFS(N - 1, newNum, K, results);
                }
            }
        }
    }

    class Solution1 {
        public int[] numsSameConsecDiff(int n, int k) {
            ArrayList<Integer> res = new ArrayList<>();
            if(n == 1) {
                return new int[] {0,1,2,3,4,5,6,7,8,9,0};
            }

            for(int i=1; i<=9; i++) {
                dfs(n, k, i, 0, i, res);
            }

            int[] arr = new int[res.size()];
            for(int i=0; i<res.size(); i++) {
                arr[i] = res.get(i);
            }

            return arr;
        }

        public static void dfs(int n, int k, int curr, int index,
                               int prev, ArrayList<Integer> res) {
            if(index == n - 1) {
                res.add(curr);
                return;
            }

            int next = prev + k;
            if(next < 10) {
                dfs(n, k, (curr * 10) + next, index + 1, next, res);
            }

            next = prev - k;

            if(k != 0 && next >= 0) {
                dfs(n, k, (curr * 10) + next, index + 1, next, res);
            }
        }
    }

    class Solution2 {

        public int[] numsSameConsecDiff(int N, int K) {

            if (N == 1)
                return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

            List<Integer> queue = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
            for(int level = 1; level < N; ++ level) {
                ArrayList<Integer> nextQueue = new ArrayList<>();
                // iterate through each number within the level
                for (Integer num : queue) {
                    Integer tailDigit = num % 10;

                    ArrayList<Integer> nextDigits = new ArrayList<>();
                    nextDigits.add(tailDigit + K);
                    if (K != 0)
                        nextDigits.add(tailDigit - K);
                    for (Integer nextDigit : nextDigits) {
                        if (0 <= nextDigit && nextDigit < 10) {
                            Integer newNum = num * 10 + nextDigit;
                            nextQueue.add(newNum);
                        }
                    }
                }
                // prepare for the next level
                queue = nextQueue;
            }

            return queue.stream().mapToInt(i->i).toArray();
        }
    }
}
