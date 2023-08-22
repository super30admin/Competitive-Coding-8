// Time Complexity : O(n+m)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Create a hashmap of characters in t and their count.
 * 2. Traverse the string s and check if the character is present in hashmap.
 * 3. If the character is present in that window, decrement the count in hashmap and also increment the matched count if the character cound is 0.
 * 4. If there are all the characters in the window, then try to shrink the window by incrementing the start pointer to find the minimum window.
 * 5. Keep track the minimum window length and start index.
 * 6. Return the substring from start index to start index + minLen.
 */

import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0){
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int start=0, end=0, minLen = Integer.MAX_VALUE, startIdx = 0, slen = s.length();
        int matched = 0;

        while(end < slen){
            char rightCh = s.charAt(end);
            if(map.containsKey(rightCh)){
                map.put(rightCh, map.get(rightCh)-1);
                if(map.get(rightCh) == 0)
                    matched++;
            }

            while(matched == map.size()){
                if(minLen > end - start +1){
                    minLen = end - start + 1;
                    startIdx = start;
                }

                char leftCh = s.charAt(start);
                if(map.containsKey(leftCh)){
                    map.put(leftCh, map.get(leftCh)+1);
                    if(map.get(leftCh) > 0)
                        matched--;
                }
                start++;
            }
            end++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}