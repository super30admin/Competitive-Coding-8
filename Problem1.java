//Time = O(m+n), m and n are lengths of strings s and t respectively
//Space = O(k), k is number of unique characters in string t 

public class Solution {
    public String minWindow(String s, String t) {
        // Edge case: If either string is empty, return an empty result.
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        // Create a map to store the frequency of characters in t.
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        // Variables to track the minimum window
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE;
        int count = t.length();  // Number of characters we need to match.

        // Expand the window by moving 'end' pointer.
        while (end < s.length()) {
            char endChar = s.charAt(end);

            // If the current character is part of t, decrease its count.
            if (tFreq.containsKey(endChar)) {
                if (tFreq.get(endChar) > 0) {
                    count--;
                }
                tFreq.put(endChar, tFreq.get(endChar) - 1);
            }
            end++;

            // When all characters are matched, try to shrink the window.
            while (count == 0) {
                // Update the minimum window size if this window is smaller.
                if (end - start < minLen) {
                    minLen = end - start;
                    minStart = start;
                }

                // Try to shrink the window by moving 'start' pointer.
                char startChar = s.charAt(start);
                if (tFreq.containsKey(startChar)) {
                    tFreq.put(startChar, tFreq.get(startChar) + 1);
                    if (tFreq.get(startChar) > 0) {
                        count++;
                    }
                }
                start++;
            }
        }

        // Return the minimum window, or "" if no such window exists.
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
