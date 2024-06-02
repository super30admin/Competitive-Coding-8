
// Using Sliding Window
import java.util.*;

class Solution {
    // Tc: O(n) Sc: O(n)
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        int requiredChars = map.size();
        Map<Character, Integer> windowMap = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            if (map.containsKey(rightChar) && windowMap.get(rightChar).intValue() == map.get(rightChar).intValue()) {
                requiredChars--;
            }

            while (requiredChars == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar) && windowMap.get(leftChar).intValue() == map.get(leftChar).intValue()) {
                    requiredChars++;
                }

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);

    }

}

/*
 * //TLE Solution
 * class Solution {
 * public String minWindow(String s, String t) {
 * // Tc: O(m*n^2) Sc: O(1)
 * String minWindow = "";
 * int minWindowLength = Integer.MAX_VALUE;
 * 
 * for (int i = 0; i < s.length(); i++) {
 * for (int j = i + t.length(); j <= s.length(); j++) {
 * String currentWindow = s.substring(i, j);
 * if (containsAllCharacters(currentWindow, t)) {
 * if (currentWindow.length() < minWindowLength) {
 * minWindow = currentWindow;
 * minWindowLength = currentWindow.length();
 * }
 * }
 * }
 * }
 * 
 * return minWindow;
 * }
 * 
 * private boolean containsAllCharacters(String s, String t) {
 * int[] charCount = new int[128];
 * for (char c : t.toCharArray()) {
 * charCount[c]++;
 * }
 * 
 * for (char c : s.toCharArray()) {
 * charCount[c]--;
 * }
 * 
 * for (int count : charCount) {
 * if (count > 0) {
 * return false;
 * }
 * }
 * 
 * return true;
 * }
 * 
 * }
 * 
 */