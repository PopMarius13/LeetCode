package daily_challenge;

public class P1689 {

    class Solution {
        public int minPartitions(String n) {
            char c = '0';
            for(int i = 0; i < n.length(); i++) {
                char cc = n.charAt(i);
                if(cc > c) {
                    c = cc;
                    if(c == '9') {
                        return 9;
                    }
                }
            }
            return Integer.parseInt(String.valueOf(c));
        }
    }
}
