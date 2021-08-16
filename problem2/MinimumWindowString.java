// Time Complexity : O(m + n), m -> Length of s, n -> Length of t
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowString {
	public String minWindow(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0) {
			return "";
		}

		Map<Character, Integer> tMap = new HashMap<>();

		for (Character ch : t.toCharArray()) {
			tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
		}

		Map<Character, Integer> sMap = new HashMap<>();

		int left = 0;
		int right = 0;
		int substringMatch = 0;

		int minWindowSize = -1;
		int minWindowLeft = 0;
		int minWindowRight = 0;

		while (right < s.length()) {
			char ch = s.charAt(right);

			if (tMap.containsKey(ch)) {
				sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
			}

			if (tMap.containsKey(ch) && sMap.get(ch).intValue() == tMap.get(ch).intValue()) {
				substringMatch++;
			}

			while (left <= right && substringMatch == tMap.size()) {
				char chLeft = s.charAt(left);

				if (minWindowSize == -1 || (right - left + 1) < minWindowSize) {
					minWindowSize = right - left + 1;
					minWindowLeft = left;
					minWindowRight = right;
				}

				if (tMap.containsKey(chLeft)) {
					sMap.put(chLeft, sMap.get(chLeft) - 1);
				}

				if (tMap.containsKey(chLeft) && sMap.get(chLeft).intValue() < tMap.get(chLeft).intValue()) {
					substringMatch--;
				}
				left++;
			}
			right++;
		}

		if (minWindowSize == -1) {
			return "";
		}
		return s.substring(minWindowLeft, minWindowRight + 1);
	}

	public static void main(String[] args) {
		MinimumWindowString obj = new MinimumWindowString();
		String s = "adobecodebanc";
		String t = "abc";
		System.out.println("Minimum window substring: " + obj.minWindow(s, t));
	}

}
