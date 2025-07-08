// Time Complexity - O(n)
//Space complexity - O(n)
// Solved on leetcode - yes
// Faced any issues - No
// We first count the frequency of characters in string t using a hash map (tMap). Then, we use the sliding window approach on string s with two pointers (left and right) to expand the window and track character frequencies needed to cover t. Whenever all required characters are present in the current window, we try to shrink the window to find the smallest possible substring, updating the result if we find a smaller valid window.
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();
        int have = 0, need = tMap.size();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE, minStart = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && window.get(c).intValue() == tMap.get(c).intValue()) {
                have++;
            }

            // Try to shrink window
            while (have == need) {
                // Update answer if this window is smaller
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (tMap.containsKey(leftChar) && window.get(leftChar).intValue() < tMap.get(leftChar).intValue()) {
                    have--;
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
