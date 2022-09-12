package daily_challenge;

import java.util.Arrays;

public class P948 {

    class Solution {
        public int bagOfTokensScore(int[] tokens, int power) {
            Arrays.sort(tokens);
            int st = 0;
            int dr = tokens.length - 1;
            int res = 0;
            while(st <= dr){
                if(power >= tokens[st]) {
                    power -= tokens[st++];
                    res++;
                } else if (st < dr) {
                    power += tokens[dr--];
                    res--;
                }
            }
            return res;
        }
    }
}
