package days_14_study_plan;

import java.math.BigInteger;

public class P278 {

    public static void main(String[] args) {
        P278.Solution s = new P278.Solution();
        System.out.println(s.firstBadVersion(2126753390));
    }

    static class Solution {
        public int firstBadVersion(int n) {
            return firstBadVersion(1, n);
        }

        public int firstBadVersion(int left, int right) {
            if( left > right) {
                return -1;
            }
            BigInteger m = new BigInteger(String.valueOf(left));
            m = m.add(new BigInteger(String.valueOf(right)));
            m = m.divide(BigInteger.TWO);
            int  mij = m.intValue();
            if ( isBadVersion(mij) && !isBadVersion(mij - 1)) {
                return mij;
            } else if ( isBadVersion(mij) ) {
                return firstBadVersion(left, mij);
            }
            return firstBadVersion( mij, right);
        }

        public boolean isBadVersion(int n) {
            if (n < 1702766719) {
                return false;
            }
            return true;
        }
    }
}
