package daily_challenge;

import java.util.HashMap;
import java.util.Map;

public class P242 {

    class Solution {
        public boolean isAnagram(String s, String t) {
            int n = s.length();
            if (n != t.length()) {
                return false;
            }
            Map<Character, Integer> letters = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                letters.put(c, letters.getOrDefault(s.charAt(i), 0) + 1);
                c = t.charAt(i);
                letters.put(c, letters.getOrDefault(s.charAt(i), 0) - 1);
            }
            System.out.println(letters);
            for (int v : letters.values()) {
                if (v != 0) {
                    return false;
                }
            }

            return true;
        }
    }

    class Solution1 {
        public boolean isAnagram(String s, String t) {
            var freq = new int[26];
            if(s.length() != t.length()) {
                return false;
            }

            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
                freq[t.charAt(i) - 'a']--;
            }

            for (int i = 0; i <= 26; ++i) {
                if (freq[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
