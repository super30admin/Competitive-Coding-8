// Time Complexity : O(S+T)
// Space Complexity : recursive - O(S+T)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
/**
 * sliding window
 * https://leetcode.com/problems/minimum-window-substring/
 *
 *
 */
class Solution {
    public String minWindow(String s, String t) {
        
        if(s == null || s.length() == 0) return "";
        
        Map<Character, Integer> tMap = new HashMap<>();
        
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> wMap = new HashMap<>();
        int start=0, end =0, min = -1, i=0, j=0, match = 0;
        
        while(j < s.length()){
            char c = s.charAt(j);
            wMap.put(c, wMap.getOrDefault(c, 0) + 1);
            
            if(tMap.containsKey(c) && tMap.get(c).intValue() == wMap.get(c).intValue()) {
                
                match++;
            }
            
            //start contracting window
            
            while(i <= j && match == tMap.size()){
                
                 if(min == -1 || min > j-i){
                    start = i;
                    end = j;
                    min = j-i;
                }
                
                char out = s.charAt(i);
                wMap.put(out, wMap.getOrDefault(out, 0) - 1);
                
                if(tMap.containsKey(out) && tMap.get(out).intValue() > wMap.get(out).intValue()) {
                    match--;
                }
                
                i++;
            }
            
            j++;
        }
        
        if(min == -1) return "";
        else return s.substring(start, end+1);
    }
}