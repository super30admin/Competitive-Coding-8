// Time complexity: O(N) - String length
//Space complexity: O(M) - Length of pattern
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        int start = 0;
        int end = 0;
        int len = 0;
        int minLen = Integer.MAX_VALUE;
        int substrStart =0;

        HashMap <Character, Integer> map = new HashMap<Character, Integer> ();
        for (char c: t.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (end = 0; end < s.length(); end++)
        {
            char c = s.charAt(end);
            if (map.containsKey(c))
            {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0)
                    len++;
            }
            while (t.length() == len)
            { 
                if(minLen > end-start + 1)
                {                    
                    minLen = end-start+1;
                    substrStart = start;
                }
                
                char strt = s.charAt(start++);
                if (map.containsKey(strt))
                {
                    if (map.get(strt) == 0)
                    {
                        len --;
                    }
                    map.put(strt, map.get(strt) + 1);
                }
               
            }
            
        }
        return minLen > s.length() ? "" : s.substring(substrStart, substrStart +minLen);
    }
}