// Time Complexity : O(n), where n is the length of s. Each character is visited at most twice (once by end and once by start) thanks to the sliding window.
// Space Complexity : O(k), where k is the number of distinct characters in t, due to the frequency HashMap.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Approach:

// Build a frequency map for all characters in t, representing how many of each character are still needed. 
//   Use two pointers (start and end) to expand a sliding window over s, decrementing counts in the map when you include a relevant character; when a count hits zero, you increment a match counter. 
//   When match equals the number of distinct characters in t (i.e., all requirements are satisfied), try to shrink the window from the left to minimize its length, updating the best (minlen and minStart) whenever you find a smaller valid window. 
//   While shrinking, if you remove a needed character and its count becomes positive, decrement match to mark the window as invalid again. 
//   Continue expanding and shrinking until end reaches the end of s, then return the smallest valid window tracked.
  
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) return "";
        int n = s.length();
        int m = t.length();
        if (n < m || n == 0 || m == 0) return "";

        int match = 0;
        int minlen = Integer.MAX_VALUE;
        int minStart = 0; // Track the start of the minimum window

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int start = 0;
        for (int end = 0; end < n; ++end) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    match++;
            }

            while (match == map.size()) {
                if (end - start + 1 < minlen) {
                    minlen = end - start + 1;
                    minStart = start; // Correctly store the actual start
                }

                char x = s.charAt(start);
                if (map.containsKey(x)) {
                    map.put(x, map.get(x) + 1);
                    if (map.get(x) > 0)
                        match--;
                }
                start++;
            }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minlen);
    }
}
