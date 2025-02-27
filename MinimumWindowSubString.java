/*
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public String minWindow(String s, String t) {
        // Base case
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // HashMap to store the frequency of characters in 't'
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Two pointers
        int left = 0, right = 0;
        int required = map.size();
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        HashMap<Character, Integer> windowCounts = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (map.containsKey(c) && windowCounts.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);

                if (map.containsKey(leftChar) && windowCounts.get(leftChar).intValue() < map.get(leftChar).intValue()) {
                    formed--;
                }

                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}