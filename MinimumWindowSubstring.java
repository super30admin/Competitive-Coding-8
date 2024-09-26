/* Time Complexity :O(n)
 * Space Complexity :O(1)
 * Did this code successfully run on Leetcode :yes
 * Any problem you faced while coding this :No
 */

import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < 1 || t.length() < 1 || s.length() < t.length()) {
            return "";
        }
        // to keep count of t string
        HashMap<Character, Integer> need = new HashMap<>();
        // to keep count of matched characters
        HashMap<Character, Integer> matched = new HashMap<>();
        int[] result = new int[2];
        String resultStr = "";
        int matchedCount = 0;
        int minLength = Integer.MAX_VALUE;

        int i = 0;
        // int j=0;
        // populate hashmap
        for (int idx = 0; idx < t.length(); idx++) {
            Character c = t.charAt(idx);
            int count = need.getOrDefault(c, 0);
            need.put(c, count + 1);

        }
        int tLen = need.size();
        for (int j = 0; j < s.length(); j++) {

            Character ch = s.charAt(j);
            // add in matched hashmap if need contains the character and if both counts
            // become equal, increase matchedcount
            if (need.containsKey(ch)) {
                matched.put(ch, matched.getOrDefault(ch, 0) + 1);
                int matchedc = matched.get(ch);
                int needc = need.get(ch);
                if (matchedc == needc) {
                    matchedCount++;
                }
            }
            // now shrink the window incrementing i such that we are just one step ahead
            // till matchedcount was equal to required and update the result
            while (matchedCount == tLen) {
                if (j - i + 1 < minLength) {
                    result[0] = i;
                    result[1] = j + 1;
                    minLength = j - i + 1;
                }
                Character chI = s.charAt(i);
                if (matched.containsKey(chI)) {
                    matched.put(chI, matched.get(chI) - 1);
                    int matchedc = matched.get(chI);
                    int needc = need.get(chI);
                    if (matchedc < needc) {
                        matchedCount--;
                    }
                }
                i++;
            }

        }
        return s.substring(result[0], result[1]);
    }
} 