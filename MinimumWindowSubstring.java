// Time Complexity : O(S) + O(T)
// Space Complexity : O(S) + O(T),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class MinimumWindowSubstring {
    class Solution {
        public String minWindow(String s, String t) {
            //corner
            if(s == null || t == null || s.length() == 0 || s.length() < t.length())
                return "";

            //logic
            Map<Character, Integer> tMap = new HashMap<>();

            for(int i=0; i<t.length(); i++) {
                char c = t.charAt(i);
                tMap.put(c, tMap.getOrDefault(c,0) +1);
            }
            int l=0;
            int r=0;
            int requiredUniqueChars = tMap.size();
            int formed = 0;
            int outputStrLen = Integer.MAX_VALUE;
            String outputStr = "";

            Map<Character, Integer> windowMap = new HashMap<>();
            for(; r<s.length(); r++) {
                //add char count to window map
                char c = s.charAt(r);
                windowMap.put(c, windowMap.getOrDefault(c,0) +1);
                //check if it and its count matches the tMap
                if(tMap.containsKey(c) && tMap.get(c).intValue() == windowMap.get(c).intValue()) {
                    formed += 1;
                }

                while(l<=r && formed == requiredUniqueChars) {
                    c = s.charAt(l);
                    if(outputStrLen > r-l+1) {
                        outputStrLen = r-l+1;
                        outputStr = s.substring(l, r+1);
                    }
                    windowMap.put(c, windowMap.getOrDefault(c,0) -1);

                    if(tMap.containsKey(c) && tMap.get(c).intValue() > windowMap.get(c).intValue()) {
                        formed -= 1;
                    }
                    l+=1;
                }
            }
            return outputStr;
        }
    }
}
