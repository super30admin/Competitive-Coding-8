//Time Complexity: O(|s|+|t|)
//Space Complexity: O(1) //constant
class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length() < t.length())
            return "";
        
        //create a frequencyMap to keep a count of each char in target string
        int[] frequencyMap = new int[128];
        
        
        for(int i=0; i<t.length(); i++)
        {
            char c = t.charAt(i);
            frequencyMap[c]++;
        }
        
        int end =0; int start =0;
        
        /*no of chars in T (can be also duplicates) we need to find exact size of window if possible, otherwise min window size*/
        int count = t.length();
        int windowSize = Integer.MAX_VALUE;
        int minLength = Integer.MAX_VALUE;
        int windowStart=0, windowEnd = 0;
        
        //iterate till the end of the String
        while(end < s.length()){
            
            char ch = s.charAt(end);
            /**
                If char count is more than 0 that means we have found one of the distinct char from T
                so decrement count.
            */
            if(frequencyMap[ch] > 0)
                count--;
            
            /*If we utilize the char lets also decrement its value in frequencyMap*/
            frequencyMap[ch]--;
            
            /** Now we have found our window*/
            while(count == 0)
            {
                char startChar = s.charAt(start);
                //if the window size is lesser than previous window, store the new min window
                //lets store the its indexes
                if(end-start < minLength)
                {
                    windowStart = start;
                    windowEnd = end;
                    minLength = end - start + 1;
                }
                
                /* As we have store the min window, lets try to decrement its size by removing first                        element from start*/
                
                /* Reset the FrequencyMap and Count value as this char is no more part of our current                        window*/
                frequencyMap[startChar]++;
                if(frequencyMap[startChar] > 0)
                {
                   count++; 
                }
                    
                start++;
            }
            
            end++;
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(windowStart, windowEnd+1);
    }
}
