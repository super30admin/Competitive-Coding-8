// Time Complexity : O(m+n) // Linear Time
// Space Complexity : O(m+n) // for two maps
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0|| t.length() == 0){
            return "";
        }

        HashMap<Character, Integer> tMap = new HashMap<>();

        for(char ch : t.toCharArray()){
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        int end = 0;

        int required = tMap.size();

        int left = 0;
        int right = 0;

        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();

        int[] ans = new int[]{-1, 0,0}; // lengthOfAns, left, right

        while(right < s.length()){
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c,0) + 1);
            if(tMap.containsKey(c) && windowCounts.get(c).intValue() == tMap.get(c).intValue()){
                formed++;
            }

            while(left <= right && formed == required) {
                // update the answer
                if(ans[0] == -1 || right - left + 1 < ans[0]){
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                char ch = s.charAt(left);

                windowCounts.put(ch, windowCounts.get(ch) - 1);
                if(tMap.containsKey(ch) && windowCounts.get(ch).intValue() < tMap.get(ch).intValue()){
                    formed--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
