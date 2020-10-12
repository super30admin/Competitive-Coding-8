    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/minimum-window-substring/
    Time Complexity for operators : o(n) .. n is the length of the string
    Extra Space Complexity for operators : o(n)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Two for loops and find the minimum window that has string. o(n*2) time complexity
        # Optimized approach: 
                              
            # 1. 
                    A) 
    */ 
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || s.length() < t.length())
            return "";
        
        int array[] = new int[128];
        int start = 0; int end = 0;
        int min = Integer.MAX_VALUE;
        String result="";
        
        for(int x=0;x<t.length();x++){
            char ch = t.charAt(x);
            ++array[ch];
        }
        
        int counter = 0;
        while(end < s.length()){
            char char_end = s.charAt(end);
            
            if(--array[char_end] >= 0){
                ++counter;
            }

            
            while(counter == t.length()){
                if(min > end-start+1){
                    min = end-start+1;
                    result = s.substring(start, end+1);
                }
                char char_start = s.charAt(start);
                if(++array[char_start] > 0){
                    --counter;
                }
                ++start;
            }
            end += 1;
        }
        
        return result;
    }
}