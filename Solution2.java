
// Minimum window substring
// Time - O(s + t)
// Space - O(1) - only characters
class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() * t.length() == 0)
            return "";
        
        Map<Character, Integer> freqmap = new HashMap<>();
        
        for(char c: t.toCharArray()){
            freqmap.put(c, freqmap.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0, min = s.length() + 1, minLeft = 0;
        int required = 0;
        while(right < s.length()){
            char rchar = s.charAt(right);
            if(freqmap.containsKey(rchar)){
                freqmap.put(rchar, freqmap.getOrDefault(rchar, 0) - 1);
                if(freqmap.get(rchar) >= 0){
                    required++;
                }
            }
            
            while(required == t.length()){
                if(right - left + 1 < min){
                    min = right - left + 1;
                    minLeft = left;
                }
                char lchar = s.charAt(left);
                if(freqmap.containsKey(lchar)){
                    freqmap.put(lchar, freqmap.getOrDefault(lchar, 0) + 1);
                    if(freqmap.get(lchar) > 0){
                        required--;
                    }
                }
                
              left++;     
                
            }
            
            
            
            right++;
        }
        
        
        return min == s.length() + 1 ? "" : s.substring(minLeft, minLeft + min);
        
    }
    
    
}

