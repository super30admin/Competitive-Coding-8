import java.util.*;

public class MinWIndow {

    // Time Complexity : O(S + T) where S is length of s, T is length of t 
    // Space Complexity : O(S + T)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    /**
     * Approach:
     * 1. Sliding window, maintain window of string s, for every incling character add that in window and check if
     * the occurrence of characters in window is same as that in string t.
     * 2. if the occurrence is same, save the start and end points of the window and compare with minimum.
     */

    public String minWindow(String s, String t) {
        
        if(s == null || s.length() == 0) {
            return s;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        
        for(char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        int i = 0; 
        int j = 0;
        int match = 0;
        int start = 0, end = 0, max = -1;
        
        while(j < s.length()) {
            char c = s.charAt(j);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            
            if(map.containsKey(c) && map.get(c).intValue() == windowMap.get(c).intValue()){
                match++;
            }
            
            
            while(i <= j && match == map.size()) {
                
                if(max == -1 || max > j-i) {
                    max = j-i;
                    start = i;
                    end = j;
                }
                
                c = s.charAt(i);
                windowMap.put(c, windowMap.getOrDefault(c, 0) - 1);
            
                if(map.containsKey(c) && map.get(c).intValue() > windowMap.get(c).intValue()){
                    match--;
                }
                i++;
            }
            
            j++;
        }
        
        
        return max == -1 ? "" : s.substring(start, end+1);
        
    }
}