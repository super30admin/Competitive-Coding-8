package competitiveCoding8;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	//Time Complexity : O(m + n), where m is length of string s and m of t
	//Space Complexity : O(n), for map
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character c: t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        int min = Integer.MAX_VALUE;
        String output = "";
        int i = 0;
        int j = 0;
        int match = 0;
        
        while(i < s.length() && j < s.length()) {
            char c = s.charAt(j);
            if(map.containsKey(c)) {
                int count = map.get(c);
                count--;
                if(count == 0)
                    match++;
                map.put(c, count);
            }
            if(match == map.size()) {
                if(j - i + 1 < min) {
                    min = j - i + 1;
                    output = s.substring(i, j + 1);
                }
                
                while(match == map.size()) {
                    char ch = s.charAt(i);
                    if(map.containsKey(ch)) {
                        int count = map.get(ch);
                        count++;
                        if(count == 1)
                            match--;
                        map.put(ch, count);
                    }
                    i++;
                    if(match == map.size()) {
                        if(j - i + 1 < min) {
                            min = j - i + 1;
                            output = s.substring(i, j + 1);
                        }
                    }
                }
            }
            j++;
        }
        
        return output;
    }
}
