// Time Complexity : O(m + n) where m = s.length(), n = t.length()
// Space Complexity : O(m + n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0)
            return "";
        
        Map<Character, Integer> dictT = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            dictT.put(ch, dictT.getOrDefault(ch, 0) + 1);
        }
        
        int required = dictT.size();
        
        int formed = 0;
        int l = 0, r = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0}; // {size, left, right}
        while(r < s.length()) {
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
            if(dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue())
                formed++;
            
            while(l <= r && formed == required) {
                c = s.charAt(l);
                if(ans[0] == -1 || r - l + 1 <= ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                
                windowCounts.put(c, windowCounts.get(c) - 1);
                if(dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue())
                    formed--;
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}