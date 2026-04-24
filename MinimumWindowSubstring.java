// // O(n + m) time, O(52) -> O(1) space

import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        int need = tMap.size();
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int start = 0;
        int end = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0)+1);

            if (tMap.containsKey(c) && window.get(c).equals(tMap.get(c))) {
                match++;
            }
 
            while (match == need) {
                if ((right - left + 1) < minLen) {
                    minLen = (right - left + 1);
                    start = left;
                    end = right;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                
                if (tMap.containsKey(leftChar) && window.get(leftChar) < tMap.get(leftChar)) {
                    match--;
                }
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        else {
            return s.substring(start, end+1);
        }
    }
}