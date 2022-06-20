package daily_challenge;

import java.util.*;

public class P820 {

    class Solution {
        public int minimumLengthEncoding(String[] words) {
            Set<String> goodWords = new HashSet<>(Arrays.asList(words));
            for (String word : words) {
                for (int k = 1; k < word.length(); ++k)
                    goodWords.remove(word.substring(k));
            }

            int answer = 0;
            for (String word : goodWords)
                answer += word.length() + 1;
            return answer;
        }

        public int minimumLengthEncoding1(String[] words) {
            TrieNode trie = new TrieNode();
            Map<TrieNode, Integer> nodes = new HashMap<>();

            for (int i = 0; i < words.length; ++i) {
                String word = words[i];
                TrieNode cur = trie;
                for (int j = word.length() - 1; j >= 0; --j)
                    cur = cur.get(word.charAt(j));
                nodes.put(cur, i);
            }
            int ans = 0;
            for (TrieNode node : nodes.keySet()) {
                if (node.count == 0)
                    ans += words[nodes.get(node)].length() + 1;
            }
            return ans;
        }
    }

    class TrieNode {
        TrieNode[] children;
        int count;

        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }

        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }
            return children[c - 'a'];
        }
    }
}

