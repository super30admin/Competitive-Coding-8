package com.recommender;


//Time Complexity : O(S + T) where S - length of string to be searched ,T - length of pattern
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


/***
 * 
 * 
 * 
 *  I have not used leetcode approach to solve this problem
 *  
 *  Following are steps to solve this problem
 *  
 *  1. Initialize 2 Integer Arrays pattern and freq and of size 256
 *  2. Count frequency of pattern charactrs and store in pattern array
 *  3. Start iterating the string
 *  	a.) Keep counting the frequency of characters and store in Freq Array
 *  	b.) Let counter =0
 *  	c.) Compare frequency of character in both array.If frequency of character in freq array is less than pattern array
 *  	 we found a match,increase the counter
 *  	d.) If counter == pattern length,it means we have found the window having all characters of  pattern. 
 *  			Now we perform following steps to minimize the window 
 *  		i.)Look for characters in window which are not in pattern.If we found characters,decrement their count so it won't be process again
 *  		ii.) Now count of pattern characters in window.If frequency of character in window is greater than frequency in pattern,reduce their count
 			iii.) If above steps are not possible in current window,repeat the above steps for next windows
 *		
 */

public class MinWindowSubstring {
	public String minWindow(String s, String t) {
		if (s.length() < t.length())
			return "";
		int pattern[] = new int[256];
		int freq[] = new int[256];

		for (char ch : t.toCharArray()) {
			pattern[ch]++;
		}

		int count = 0;
		int min = Integer.MAX_VALUE, start = 0;
		int startIndex = -1;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			freq[ch]++;

			if (pattern[ch] != 0 && freq[ch] <= pattern[ch]) {
				count++;
			}

			if (count == t.length()) {
				while (freq[s.charAt(start)] > pattern[s.charAt(start)] || pattern[s.charAt(start)] == 0) {
					if (freq[s.charAt(start)] > pattern[s.charAt(start)]) {
						freq[s.charAt(start)]--;
					}
					start++;
				}
				int len = i - start + 1;
				if (min > len) {
					min = Math.min(len, min);
					startIndex = start;
				}
			}

		}
		if (startIndex == -1)
			return "";
		return s.substring(startIndex, startIndex + min);
	}

	public static void main(String args[]) {
		MinWindowSubstring min = new MinWindowSubstring();

		String s = "AADOBECAAODEBAANC";
		String t = "AAC";

		System.out.println(min.minWindow(s, t));
	}
}
