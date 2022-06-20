package leetcode_75_study_plan;

public class P392 {

    public static void main(String[] args) {
        System.out.println(isSubsequence("aaaaa", "bbaaaa"));
    }

    public static boolean isSubsequence(String s, String t) {
        int p1 = 0, p2 = 0;

        int sLength = s.length();
        int tLength = t.length();
        while(p1 < sLength && p2 < tLength) {
            if(s.charAt(p1) == t.charAt(p2)) {
                p1 += 1;
            }
            p2 += 1;
        }

        return p1 == s.length();
    }
}
