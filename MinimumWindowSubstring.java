//TC: O(n) where n is length of string s
//SC :O(k) where k is number of unique chars in string t
//approach: two pointers/sliding window and hashing


import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int l = 0;
        int r = 0;
        int start = 0;
        int needed;
        int formed = 0;
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        needed = tMap.size();

        while (r < s.length()) {
            char c = s.charAt(r);
            if (tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                if (tMap.get(c) == sMap.get(c)) {
                    formed++;
                }
            }

            while (formed == needed && l <= r) {
                if (r - l + 1 < minLength) {
                    start = l;
                    minLength = r - l + 1;
                }

                char lChar = s.charAt(l);
                if (sMap.containsKey(lChar)) {
                    sMap.put(lChar, sMap.get(lChar) - 1);
                    if (sMap.get(lChar) < tMap.get(lChar))
                        formed--;
                }
                l++;
            }
            r++;

        }

        return minLength < Integer.MAX_VALUE ? s.substring(start, start + minLength) : "";
    }

}
