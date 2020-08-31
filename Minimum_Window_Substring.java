import java.util.HashMap;

class Solution {
	//Approach: Sliding Window
	//1. Fast pointer will iterate over the string s. Slow pointer will move only when we have acheived a perfect match with other characters. So to shirnk the window we will move slow
	// and check if still we have a desirable window. If we have, then move slow again
	//2. Orelse the loop breaks and stop moving slow and again move fast and keep on checking for a desirable window. This way we will be able to achieve a minimum window of characters.
    public String minWindow(String s, String t) {
        //edge case
        if(s == null || t == null || s.length() < t.length())return "";
        
        //map for chars in t
        HashMap<Character, Integer> map =  new HashMap<>();
        for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        
        //variables needed for iteration
        int minLeft = 0, minRight = 0, min  = s.length();
        boolean flag = false;
        
        int slow = 0, fast = 0, match = 0;
        while(fast < s.length())
        {
            //incoming character
            char in = s.charAt(fast);
            if(map.containsKey(in))
            {
                int count = map.get(in);
                count--;
                if(count >= 0)
                    match++;
                map.put(in, count);
            }
          
            //outgoing char
            while(match == t.length() && slow <= fast)
            {
                flag = true;
                int curLen = fast + 1 - slow;
                if(curLen <= min){
                    minLeft = slow;
                    minRight = fast;
                    min = curLen;
                }
                
                //shrink left
                char out = s.charAt(slow);
                if(map.containsKey(out))
                {
                    int count = map.get(out);
                    count++;
                    if(count >= 1)
                        match--;
                    map.put(out, count);                    
                }
                slow++;
            }
            fast++;
        }
        return flag == true ? s.substring(minLeft, minRight + 1): "";
    }
}

//For MinStack class
//Time Complexity : O(m + n) m - length of s and n - length of t.
//Space Complexity : O(n) for storing characters in t.
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :