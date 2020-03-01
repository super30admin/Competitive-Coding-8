// Time complexity is O(n)
// Space complexity is O(n)
// This solution is submitted on leetcode

import java.util.HashMap;

public class BigN105MinimumSubStringWindow {
	class Solution {
		public String minWindow(String s, String t) {
			// edge case
			if (s == null || s.length() == 0 || t == null || t.length() == 0)
				return "";
			HashMap<Character, Integer> window = new HashMap<>();
			HashMap<Character, Integer> minWindow = new HashMap<>();
			for (int i = 0; i < t.length(); i++) {
				char c = t.charAt(i);
				int count = window.getOrDefault(c, 0);
				window.put(c, count + 1);
			}
			int low = 0;
			int right = 0;
			int required = window.size();
			int expected = 0;
			int[] result = { -1, 0, 0 };
			while (right < s.length()) {
				char c = s.charAt(right);
				minWindow.put(c, minWindow.getOrDefault(c, 0) + 1);
				if (window.containsKey(c) && minWindow.get(c).intValue() == window.get(c).intValue()) {
					expected++;
				}

				while (low <= right && expected == required) {
					c = s.charAt(low);
					if (result[0] == -1 || result[0] > (right - low) + 1) {
						result[0] = (right - low) + 1;
						result[1] = low;
						result[2] = right;
					}

					minWindow.put(c, minWindow.get(c) - 1);
					if (window.containsKey(c) && minWindow.get(c).intValue() < window.get(c).intValue()) {
						expected--;
					}

					low++;
				}
				right++;
			}
			return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
		}
	}
}