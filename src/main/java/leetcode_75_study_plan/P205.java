package leetcode_75_study_plan;

import java.util.;

public class P205 {

    public static void main(String[] args) {
        isIsomorphic("badc", "baba");
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> helper1 = new HashMap<>();
        Map<Character, Character> helper2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(helper1.getOrDefault(s.charAt(i), '0') != '0' && helper1.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            } else if (helper2.getOrDefault(t.charAt(i), '0') != '0' && helper2.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
            else{
                helper1.put(s.charAt(i), t.charAt(i));
                helper2.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
