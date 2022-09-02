package daily_challenge;

import java.util.;

public class P890 {

    class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> ans = new ArrayList<>();
            Map<Integer, Integer> decoder1;
            Map<Integer, Integer> decoder2;
            int n = pattern.length();

            for (String word : words) {
                if (n == word.length()) {
                    decoder1 = new HashMap<>();
                    decoder2 = new HashMap<>();
                    boolean match = true;
                    for (int i = 0; i < n; i++) {
                        int currentLetterPattern = pattern.charAt(i) - 'a' + 1;
                        int currentLetterWord = word.charAt(i) - 'a' + 1;
                        if (decoder1.getOrDefault(currentLetterPattern, -1) == -1 && decoder2.getOrDefault(currentLetterWord, -1) == -1) {
                            decoder1.put(currentLetterPattern, currentLetterWord);
                            decoder2.put(currentLetterWord, currentLetterPattern);
                        } else if (decoder1.getOrDefault(currentLetterPattern, -1) != currentLetterWord || decoder2.getOrDefault(currentLetterWord, -1) != currentLetterPattern) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        ans.add(word);
                    }
                }
            }

            return ans;
        }
    }


    class Solution1 {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> ans = new ArrayList();
            for (String word: words)
                if (match(word, pattern))
                    ans.add(word);
            return ans;
        }

        public boolean match(String word, String pattern) {
            Map<Character, Character> m1 = new HashMap();
            Map<Character, Character> m2 = new HashMap();

            for (int i = 0; i < word.length(); ++i) {
                char w = word.charAt(i);
                char p = pattern.charAt(i);
                if (!m1.containsKey(w)) m1.put(w, p);
                if (!m2.containsKey(p)) m2.put(p, w);
                if (m1.get(w) != p || m2.get(p) != w)
                    return false;
            }

            return true;
        }
    }

    class Solution2 {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> ans = new ArrayList();
            for (String word: words)
                if (match(word, pattern))
                    ans.add(word);
            return ans;
        }

        public boolean match(String word, String pattern) {
            Map<Character, Character> M = new HashMap();
            for (int i = 0; i < word.length(); ++i) {
                char w = word.charAt(i);
                char p = pattern.charAt(i);
                if (!M.containsKey(w)) M.put(w, p);
                if (M.get(w) != p) return false;
            }

            boolean[] seen = new boolean[26];
            for (char p: M.values()) {
                if (seen[p - 'a']) return false;
                seen[p - 'a'] = true;
            }
            return true;
        }
    }


    class Solution3 {
        public static List<String> findAndReplacePattern(String[] words, String pattern) {

            List<String> list=new LinkedList<>();

            for(int i=0;i<words.length;i++){
                if(checkPattern(words[i],pattern)){
                    list.add(words[i]);
                }
            }
            return list;
            //abb
            //mee


        }
        private static boolean checkPattern(String word, String pattern){

            for(int i=0;i<word.length();i++){
                System.out.println(word.charAt(i) + " --- " + pattern.charAt(i));
                System.out.println(word.indexOf(word.charAt(i)) + " --- " + pattern.indexOf(pattern.charAt(i)));
                if(word.indexOf(word.charAt(i))!=pattern.indexOf(pattern.charAt(i)))
                    return false;
            }
            return  true;
        }
    }
}
