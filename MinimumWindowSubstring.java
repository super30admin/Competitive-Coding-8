package CompetitiveCoding8;

import java.util.HashMap;

/*S30 FAANG Problem #109 {Medium}- https://www.youtube.com/watch?v=TQcPVaMxodE&list=PLWtKyKogBpBDSDsgA3mcSlstDoKPNGSx0&index=17
you are given a string S and a string T, and you have to find the minimum window in S such that it can contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"

Output: "BANC"

Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
Source Link: https://leetcode.com/problems/minimum-window-substring/
-------------------------------------------------------------------------------------------------------
Time complexity :O(S + T) 
space complexity:O(S + T) 
Approach:
Did this code run successfully in leetcode : yes
problems faces : no*/

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        
        if(t.length()== 0 || s.length()==0 || t.length() > s.length()) return "";

        HashMap<Character, Integer> tmap = new HashMap<Character, Integer>();
        int requiredLength = t.length();

        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int formedLength = 0;
        //result array will contain 3 values, window size,left pointer,right point.
        int[] result = { -1, 0, 0 };

        HashMap<Character, Integer> windowMap = new HashMap<Character, Integer>();

        while (right < s.length()) {
            windowMap.put(s.charAt(right), windowMap.getOrDefault(s.charAt(right), 0) + 1);
            if (tmap.containsKey(s.charAt(right)) && windowMap.get(s.charAt(right)) <= tmap.get(s.charAt(right))) {

                formedLength++;
            }

            while (left <= right && formedLength == requiredLength) {
                if (result[0] == -1 || right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }
                windowMap.put(s.charAt(left), windowMap.get(s.charAt(left)) - 1);
                if (tmap.containsKey(s.charAt(left)) && windowMap.get(s.charAt(left)) < tmap.get(s.charAt(left))) {
                    formedLength--;
                }
                left++;
            }

            right++;
        }

        return result[0]==-1 ? "" : s.substring(result[1], result[2] + 1);
    }
}
