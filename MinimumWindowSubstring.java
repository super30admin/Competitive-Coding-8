/**
Leetcode: https://leetcode.com/problems/minimum-window-substring/

Given two strings s and t, return the minimum window in s which will contain all the characters in t. 
If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, 
it is guaranteed that there will always be only one unique minimum window in s.

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
**/
class Solution 
{
    public String minWindow(String s, String t) 
    {
        if(s == null || t == null)
            return "";
            
        int occurences[] = new int[128];
        int minLength = Integer.MAX_VALUE;
        String result = "";
        int count = 0;
        int left = 0;
        int right = 0;
        
        // keeping the track of count of each character in the text T
        for(char ch: t.toCharArray())
            occurences[ch]++;
        
        for( right = 0 ; right < s.length(); right++)
        {
            // this means that the charcter was present in the text T
            if( --occurences[s.charAt(right)] >= 0)
            {
                count++;
            }
            
            // have found all the characters in the current window
            while( count == t.length())
            {
                int currentLength = right - left + 1;
                
                if( currentLength < minLength)
                {
                    minLength = currentLength;
                    
                    result = s.substring(left, right + 1);
                }
                
                // check if the left most character was contributing to count
                if( ++occurences[s.charAt(left)] > 0)
                    count--;
                    
                left++;
            }
        
        }
        
        return result;
        
        
    }
}