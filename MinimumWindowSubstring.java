/*
 * #76. Minimum Window Substring
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:

1. If there is no such window in S that covers all characters in T, return the empty string "".
2. If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

 */


/*
 * Time Complexity: O (m + n) -> 'm' to traverse string 't' and 'n' to traverse string 's'
 * 
 * Space Complexity: O (m + n) -> 'pattern' map stores count of 'm' characters in string 't' and 'window' map stores count of 'n' characters from current window in 'window' map
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.competitivecoding8;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	 public String minWindow(String s, String t) {
	        
	        // base conditon
	        if(s.length() == 0 || t.length() == 0){
	            return ""; // return empty string
	        }
	         
	        // Create a pattern map which keeps track of count of all unique characters in 't'
	        Map<Character, Integer> pattern = new HashMap<Character, Integer>();
	        
	        // Create a window map which keeps count of all unique characters in the current window
	        Map<Character, Integer> window = new HashMap<Character, Integer>();
	        
	        // Traverse through string 't' and fill the pattern map
	        for(int i = 0; i < t.length(); i++){
	            char ch = t.charAt(i);
	            pattern.put(ch, pattern.getOrDefault(ch, 0) + 1);
	        }
	        
	        // Initialize the pointers to find the minimum window 
	        // Initialize a variable 'match' which indicates if we have a desired window with all charcters present from string 't'
	        // Declare an array that stores length of current window, start and end of a desired window
	        int start = 0;
	        int end = 0;
	        int match = 0;
	        int[] ans = {-1, 0, 0};
	        
	        // Now, traverse through the string 's', 'end' pointer will go out of bounds before 'start' pointer so check for that
	        while(end < s.length()){
	            
	            // Get the character at 'end' pointer
	            char ch_end = s.charAt(end);
	            
	            // Increment the count of that character in window map
	            window.put(ch_end, window.getOrDefault(ch_end, 0) + 1);
	            
	            // If the chracter is in a pattern map, and its count is same as the count in pattern map,
	            // meaning, we have found a character from pattern in current window, increment match 
	            if(pattern.containsKey(ch_end) && window.get(ch_end).intValue() == pattern.get(ch_end).intValue()){
	                match++;
	            }
	            
	            // When match is equal to the size of pattern map, we have a desired window with all the characters in 't'
	            // Once we have a desired window, we try to reduce its size to see if we can find a minimum window with all the characters in 't'. We increment the start pointer until it is <= end pointer and match is equal to size of pattern map(we have a desired window)
	            while(start <= end && match == pattern.size()){
	                
	                // Get the character
	                char ch_st = s.charAt(start);
	                
	                /*
	                * Before incrementing start pointer:
	                *   1. Update the length, start, and end of current desired window
	                *   2. Decrement the count of a character at 'start' pointer in window map
	                *       - If that character is present in pattern and its count is less in window map, meaning we will loose that character from current window, then decrement match to indicate we have undesired window
	                */
	                
	                // We have a desired window, update the length, start, and end of that window if length of current window is less than previous window. Initially, length, start, and end will be updated when it is -1(first desired window)
	                if(ans[0] == -1 || end - start + 1 < ans[0]){
	                    ans[0] = end - start + 1;
	                    ans[1] = start;
	                    ans[2] = end;
	                }
	                
	                // Decrement the count of a character at 'start' pointer in window map
	                window.put(ch_st, window.get(ch_st) - 1);
	                
	                // If that character is present in pattern and its count is less in window map, meaning we will loose that character from current window, then decrement match to indicate we have undesired window
	                
	                // '==' and '<' operator does not work with primitive types -> Integer, so used intValue()
	                if(pattern.containsKey(ch_st) && window.get(ch_st).intValue() < pattern.get(ch_st).intValue()){
	                    match--;
	                }
	                
	                start++;
	                
	            }
	            
	            // We increment the end pointer until we get a desired window 
	            end++;
	            
	            
	        }
	        
	        // When 'end' pointer goes out of bounds, return the minimum window substring or empty string if not found
	        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	        
	    }
	    
}
