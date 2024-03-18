//TC - O(m+n)
//SC - O(1)
import java.util.HashMap;

class Solution {
	int minLen = Integer.MAX_VALUE;
	String output;
	int match = 0;

	public String minWindow(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (Character ch : t.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int start = 0;
		int end = 0;
		

		while (end < s.length()) {
			char ch = s.charAt(end);
			if (map.containsKey(ch)) {
				int old_count = map.get(ch);
				map.put(ch, old_count - 1);
				int new_count = map.get(ch);
				// 1 --> 0 match++
				if (old_count == 1 && new_count == 0)
					match++;
			}
			if (match == map.size()) {
				output = s.substring(start, end + 1);
				minLen = Math.min(minLen, output.length());
				start = checkSubstrings(start, end, s, map);
			}
			end++;
		}
		return output;

	}

	private int checkSubstrings(int start, int end, String s, HashMap<Character, Integer> map) {

		while (start != end) {
			if (match < map.size())
				return start;
			char out = s.charAt(start);
			start++;
			if (map.containsKey(out)) {
				map.put(out, map.getOrDefault(out, 0) + 1);
				int new_count = map.get(out);
				// 0 --> 1 match--
				if (new_count == 1)
					match--;
			}
			if (match == map.size()) {
				output = s.substring(start, end + 1);
				minLen = Math.min(minLen, output.length());
			}

		}
		match--;
		return start;
	}
}

public class MinWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ab";
		String t = "a";
		Solution ob = new Solution();
		System.out.println(ob.minWindow(s, t));

	}

}
