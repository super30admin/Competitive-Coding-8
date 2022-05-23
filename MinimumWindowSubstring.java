// Time Complexity : O(s + t)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        
        if(t == null || t.length() == 0) return "";
        
        int left = 0, right = 0, match = 0;
        String result = "";
        int windowLength = Integer.MAX_VALUE;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char ch: t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        while(right < s.length()) {
            
            char current = s.charAt(right);
            
            if(map.containsKey(current)) {
                map.put(current, map.get(current) - 1);
                
                if(map.get(current) == 0) {
                    match++;
                }
            }
                   
            while(match == map.size() && right - left + 1 >= t.length()) {
                int windowSize = right - left + 1;

                if(windowSize < windowLength) {
                    result = s.substring(left, right + 1);
                    windowLength = windowSize;
                }
                
                char leftChar = s.charAt(left);
                if(map.containsKey(leftChar)) {
                map.put(leftChar, map.get(leftChar) + 1);

                    if(map.get(leftChar) > 0) {
                        match--;
                    }
                }
                left++;
            }
            
            right++;

        }
        return result;
    }
}