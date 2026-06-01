
// Time Complexity : O(m + n) where m is the length of string s and n is the length of string t
// Space Complexity : O(n) where n is the length of  string t
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//  1. We will use two pointers(sliding window) to keep track of the current window in string s and a HashMap to keep track of the count of characters in string t.
//  2. We will iterate through string s using the right pointer and update the count
//    of characters in the HashMap. If the count of a character in the HashMap is greater than 0, we will increment the count variable.
// 3. We will then check if the count variable is equal to the length of string t, which means we have found a valid window. We will then try to shrink the window from the left pointer until we no longer have a valid window.
// 4. We will keep track of the minimum length of the valid window and its starting index. Finally, we will return the substring of string s that corresponds to the minimum length valid window.
// 5. If we do not find any valid window, we will return an empty string.
// 6. The time complexity of this algorithm is O(m + n) because we are iterating through string s once and string t once to build the HashMap. The space complexity is O(n) because we are storing the count of characters in string t in the HashMap.


import java.util.*;

class Solution {
    public String minWindow(String s, String t) {

        if (s == null || s.length() == 0 ||
            t == null || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        int right = 0;

        while (right < s.length()) {

            char rightChar = s.charAt(right);

            if (map.containsKey(rightChar)) {

                if (map.get(rightChar) > 0) {
                    count++;
                }

                map.put(rightChar, map.get(rightChar) - 1);
            }

            while (count == t.length()) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                if (map.containsKey(leftChar)) {

                    map.put(leftChar, map.get(leftChar) + 1);

                    if (map.get(leftChar) > 0) {
                        count--;
                    }
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLen);
    }
}