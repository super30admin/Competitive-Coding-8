// Time Complexity: O(n + m), where n is the length of s and m is the length of t.

// The sliding window expands and shrinks with linear time complexity. Each character is processed at most twice (once by the right pointer and once by the left pointer).
// Space Complexity: O(m), where m is the number of unique characters in t.


class Solution {
    public String minWindow(String s, String t) {
        // If t is longer than s, it's impossible to find a window, so return an empty string.
        if(t.length() > s.length()) return "";

        // Create a frequency map for characters in string t
        HashMap<Character, Integer> freqMapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            freqMapT.put(c, freqMapT.getOrDefault(c, 0) + 1);
        }

        int left = 0;   // Left pointer for the sliding window
        int right = 0;  // Right pointer for the sliding window
        int match = 0;  // Number of characters with matching frequency in the current window
        int result = Integer.MAX_VALUE;  // Length of the smallest valid window found
        int subLeft = 0;  // Start index of the smallest valid window
        int subright = 0; // End index of the smallest valid window

        // Start expanding the window by moving the right pointer
        while (right < s.length()) {
            char rightChar = s.charAt(right);

            // If the current character is in t, update its frequency in the map
            if (freqMapT.containsKey(rightChar)) {
                int freq = freqMapT.get(rightChar) - 1;
                freqMapT.put(rightChar, freq);

                // If the frequency of this character matches exactly, increase the match count
                if (freq == 0)
                    match++;
            }

            // When all characters in t are matched in the current window
            if (match == freqMapT.size()) {
                // Try to shrink the window by moving the left pointer
                while (match == freqMapT.size()) {
                    char leftChar = s.charAt(left);

                    // If the leftmost character is part of t, update its frequency in the map
                    if (freqMapT.containsKey(leftChar)) {
                        int freq = freqMapT.get(leftChar) + 1;
                        freqMapT.put(leftChar, freq);

                        // If the frequency becomes greater than 0, it means it's no longer fully matched
                        if (freq == 1) {
                            match--;
                        }
                    }

                    // Update the smallest window if the current one is smaller
                    if (right - left + 1 < result) {
                        subLeft = left;
                        subright = right;
                        result = Math.min(result, right - left + 1);
                    }

                    // Move the left pointer to further shrink the window
                    left++;
                }
            }

            // Move the right pointer to expand the window
            right++;
        }

        // Return the smallest valid window, or an empty string if no valid window was found
        return result != Integer.MAX_VALUE ? s.substring(subLeft, subright + 1) : "";
    }
}
