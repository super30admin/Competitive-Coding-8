// TC: O(m + n)
// SC: O(n)

// Approach: Maintain a sliding window and a match variable
// whenever you get a match; move the start of the window to the next
// possible substring and adjust the match count accordingly. If you dont
// get a match, keep increasing the end of the window.

import java.util.HashMap;
import java.util.Map;

class MinWindowSubstring {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        int match = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        while (start < s.length() && !map.containsKey(s.charAt(start))) {
            start++;
        }

        // no matching character found;
        if (start == s.length()) {
            return "";
        }

        int end = start;
        String res = "";
        int resLength = Integer.MAX_VALUE;

        while (start < s.length() && start <= end) {
            if (match == map.size()) {
                if (end - start < resLength) {
                    res = s.substring(start, end);
                    resLength = end - start;
                }
            }

            // move start
            if (match == map.size() || end == s.length()) {
                // move start till the next valid substring
                char startChar = s.charAt(start);
                int startCount = map.get(startChar);
                map.put(s.charAt(start), startCount + 1);
                // lost the match
                if (startCount == 0) {
                    match--;
                }
                start++;
                while (start < s.length() && !map.containsKey(s.charAt(start))) {
                    start++;
                }
                continue;
            }

            // only process this when
            char current = s.charAt(end);
            if (map.containsKey(current)) {
                int currentValue = map.get(current);
                if (currentValue == 1) {
                    match++;
                }
                map.put(current, currentValue - 1);
            }
            end++;
        }

        return res;
    }
}