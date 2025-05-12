// Time Complexity : O(s.length + t.length)
// Space Complexity : O(t.length) -> due to hashmap storing characters in string `t`
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use a HashMap to store the frequency of each character in string `t`.
//   - Use a sliding window approach with two pointers `i` and `j` to track the window in string `s`.
//   - Expand the window by moving `j` until all required characters are matched (count == 0).
//   - Then try shrinking from the left by moving `i` to find the smallest valid window.
//   - Update the minimum window length and its starting index during the shrinking process.
//   - Return the minimum window substring found.

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> hmap = new HashMap<>();
        if(s.length() < t.length()) {
            return "";
        }

        for(char c: t.toCharArray()) {  //traverse for each char in 't'
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);   //put new value or increase val if key present already
        }

        int i = 0, j = 0;   //initializing window indices
        int startIndex = 0; //store start of window
        int min = Integer.MAX_VALUE;    //value to compare window size
        int temp = min; //temp to store min value
        int count = hmap.size();    //intial value of count i.e. unique char in Map
        while(j < s.length()) {     //loop till j reaches end of 's'
            char c = s.charAt(j);
            if(hmap.containsKey(c)) {
                hmap.put(c, hmap.getOrDefault(c, 0) - 1);   //decrement val by 1
                if(hmap.get(c) == 0) {  //if val becomes 0 reduce count
                    count--;
                }
            }
            if(count > 0) { //count greater than 0 so move j to get window
                j++;
            }

            if(count == 0) {    //found window now increment i to get minimum window substring
                temp = min;
                min = Math.min(min, j - i + 1);
                if(temp != min) {   //if new min found modify start index
                    startIndex = i;
                }

                while(count == 0) {     //increment i till count is 0
                    char ic = s.charAt(i);
                    if(hmap.containsKey(ic)) {
                        hmap.put(ic, hmap.getOrDefault(ic, 0) + 1); //increment val in map
                        if(hmap.get(ic) > 0) {  //if val gets greater than 0
                            count++;    //increment count
                        }
                    }
                    i++;
                    if(count == 0) {    //if count is still 0 then update min and startindex of window
                        min = Math.min(min, j - i + 1);
                        if(temp != min) {   //if new min found modify start index
                            startIndex = i;
                        }
                    }
                }
                j++;
            }
        }
        if(min == Integer.MAX_VALUE) {   //min not found
            return "";  //return empty string i.e. no substring found
        }
        return s.substring(startIndex, startIndex + min);   //return substring
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solver = new MinimumWindowSubstring();

        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = solver.minWindow(s, t);

        System.out.println("Minimum window substring: " + result);  //expected: "BANC"
    }
}
