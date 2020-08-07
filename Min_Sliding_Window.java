
//TC - O(N)
//SC - O(N)
import java.util.*;

class Solution1 {
	public String minWindow(String s, String t) {
		HashMap<Character, Integer> tmap = new HashMap<>();
		int size = t.length();
		int minLen = Integer.MAX_VALUE;
		String result = "";
		for (int i = 0; i < t.length(); i++) {
			tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
		}
		int i = 0;
		int total = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			if (!tmap.containsKey(c))
				continue;
			int count = map.getOrDefault(c, 0);
			if (count < tmap.get(c))
				total++;
			map.put(c, count + 1);
			if (total == size) {
				while (!tmap.containsKey(s.charAt(i)) || map.get(s.charAt(i)) > tmap.get(s.charAt(i))) {
					char pc = s.charAt(i);
					if (tmap.containsKey(pc) && map.get(pc) > tmap.get(pc)) {
						map.put(pc, map.get(pc) - 1);
					}

					i++;
				}

				if (minLen > j - i + 1) {
					minLen = j - i + 1;
					result = s.substring(i, j + 1);
				}
			}
		}
		return result;
	}
}