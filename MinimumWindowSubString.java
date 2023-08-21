// Time Complexity : O(m+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;

public class MinimumWindowSubString {

    class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character,Integer> map = new HashMap<>();

            for(int i=0; i<t.length(); i++)
            {
                char c = t.charAt(i);
                map.put(c,map.getOrDefault(c,0)+1);
            }

            int i=0; int j=0;int match = 0;
            int len = Integer.MAX_VALUE;
            int left = 0; int right = 0;

            while(j<s.length())
            {
                char rightChar = s.charAt(j);
                j++;
                if(map.containsKey(rightChar))
                {
                    int frq = map.get(rightChar);
                    frq--;
                    map.put(rightChar,frq);
                    if(frq == 0)match++;
                }
                if(match < map.size())
                {
                    continue;
                }

                while(match == map.size())
                {
                    char leftChar = s.charAt(i);
                    if(map.containsKey(leftChar))
                    {
                        int freq = map.get(leftChar);
                        freq++;
                        map.put(leftChar,freq);
                        if(freq == 1) match--;
                    }
                    i++;
                }

                if(j-i < len)
                {
                    len = j - i;
                    left = i-1;
                    right = j;
                }
            }
            if(len == Integer.MAX_VALUE) return "";
            else return s.substring(left,right);

        }
    }
}
