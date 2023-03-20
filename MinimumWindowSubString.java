import java.util.HashMap;
import java.util.Map;
//Time Complexity : O(M) 
//Space Complexity : O(N) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Put the t in map with its character counts. Then iterate over s and reduce
 * the count for the character in map if it is present. Each time when count is
 * reduced, increment match count. If match count is equal to t size, then
 * calculate the size of the window by doing current index - start index + 1.
 * Then start removing one character at a time from start index. If character is
 * present in map, then update its count by +1 and if the existing count is 0,
 * that means all characters were used in earlier substring. So reduce the match
 * count. That means there is one char missing in the window now. return the
 * substring from calcuated start index to min length calculated.
 *
 */
class Solution {
	public String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		int start = 0, end = 0;
		int match = 0;
		int minLen = Integer.MAX_VALUE, startIdx = -1;
		for (char c : t.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);
		for (end = 0; end < s.length(); end++) {
			char c = s.charAt(end);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) >= 0)
					match++;
			}

			while (match == t.length()) {
				if (minLen > end - start + 1) {
					minLen = end - start + 1;
					startIdx = start;
				}

				char l = s.charAt(start++);
				if (map.containsKey(l)) {
					if (map.get(l) == 0)
						match--;
					map.put(l, map.get(l) + 1);
				}
			}
		}
		return minLen > s.length() ? "" : s.substring(startIdx, startIdx + minLen);
	}
}
