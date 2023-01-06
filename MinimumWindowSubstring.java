//Time Complexity: O(m+n) , where m is the no. of characters in string s  and n is the no. of characters in string t
//Space Complexity: O(n), where n is the no. of characters in string t.

import java.util.HashMap;

public class MinimumWindowSubstring {
    static class Solution {
        public String minWindow(String s, String t) {
            if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) {
                return "";
            }
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int minLen = Integer.MAX_VALUE;
            int match = 0;
            int slow = 0;
            int min = 0;

            for (int fast = 0; fast < s.length(); fast++) {
                char c = s.charAt(fast);
                if (map.containsKey(c)) {
                    int cnt = map.get(c);
                    cnt--;
                    map.put(c, cnt);
                    if (cnt >= 0) {
                        match++;
                    }
                }
                while (match == t.length()) {
                    if (minLen > fast - slow + 1) {
                        minLen = fast - slow + 1;
                        min = slow;
                    }

                    if (map.containsKey(c)) {
                        int cnt = map.get(c);
                        cnt++;
                        map.put(c, cnt);
                        if (cnt > 0) {
                            match--;
                        }
                    }
                    slow++;

                }

            }
            if (minLen > s.length()) {
                return "";
            }

            return s.substring(min, min + minLen);

        }
    }
}
