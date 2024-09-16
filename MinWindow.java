// Problem 76. Minimum Window Substring
// Time Complexity : O(s+t)
// Space Complexity : O(s+t)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> t_freq = new HashMap<>();
        for (char c : t.toCharArray()) {
            t_freq.put(c, t_freq.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> window_freq = new HashMap<>();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0; // To store the start of the minimum window
        int required = t_freq.size(); // Number of unique characters in t
        int formed = 0; // Number of characters that have the required frequency in the current window
        while (right < s.length()) {
            char c = s.charAt(right);
            window_freq.put(c, window_freq.getOrDefault(c, 0) + 1);
            if (t_freq.containsKey(c) && window_freq.get(c).intValue() == t_freq.get(c).intValue()) {
                formed++;
            }
            while (left <= right && formed == required) {
                c = s.charAt(left);
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                window_freq.put(c, window_freq.get(c) - 1);
                if (t_freq.containsKey(c) && window_freq.get(c).intValue() < t_freq.get(c).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
