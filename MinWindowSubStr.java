// Time Complexity : O(S+T) // S and T and length of input strings
// Space Complexity : O(S+T) //hashmap sizes
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/*
 * 1. Sliding window approach using two pointers.
 * 2. start left and right pointers at the starting of string.
 * 3. PRepare map of char counts for string t.
 * 4. while traveling through s maintain the found character count in a map.
 * 5. when all characters count is matched capture the pointers.
 * 6. on match move left pointer and verfiy is it matching or not to find min length string. 
 */

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubStr {
	public String minWindow(String s, String t) {

		if (t.length() > s.length())
			return "";

		Map<Character, Integer> tmap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			tmap.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		Map<Character, Integer> curmap = new HashMap<>();

		int startIndex = 0;
		int endIndex = Integer.MAX_VALUE;

		int matchCount = 0;

		int leftp = 0;
		int rightp = 0;

		while (rightp <= s.length()) {

			if (matchCount == tmap.size()) {
				if (endIndex - startIndex > rightp - leftp) {
					startIndex = leftp;
					endIndex = rightp;
				}

				if (tmap.containsKey(s.charAt(leftp))) {
					curmap.compute(s.charAt(leftp), (k, v) -> v - 1);
					if (curmap.get(s.charAt(leftp)) < tmap.get(s.charAt(leftp))) {
						matchCount--;
					}
				}
				leftp++;
			} else if (matchCount != tmap.size() && rightp == s.length()) {
				break;
			} else {
				if (tmap.containsKey(s.charAt(rightp))) {
					curmap.compute(s.charAt(rightp), (k, v) -> v == null ? 1 : v + 1);
					if (curmap.get(s.charAt(rightp)) == tmap.get(s.charAt(rightp))) {
						matchCount++;
					}
				}
				rightp++;
			}

		}

		if (endIndex == Integer.MAX_VALUE) {
			return "";
		} else {
			return s.substring(startIndex, endIndex);
		}
	}

	public static void main(String[] args) {
		System.out.println(new MinWindowSubStr().minWindow("ADOBECODEBANC","ABC"));
	}
}
