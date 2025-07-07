import java.util.*;

//Time Complexity: O(n)
//Space Complexity: O(n) for the hashmap
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return "";

        HashMap<Character, Integer> map = new HashMap();
        for (Character ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> current = new HashMap();
        int l = 0, r = 0, formed = 0;
        int[] ans = new int[] { -1, 0, 0 };
        while (r < s.length()) {
            char c = s.charAt(r);

            current.put(c, current.getOrDefault(c, 0) + 1);
            if (map.containsKey(c) && current.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }
            // Try to contract the window until it ceases to be 'shortest viable'
            while (l <= r && formed == map.size()) {
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                current.put(c, current.get(c) - 1);
                if (map.containsKey(c) && current.get(c).intValue() < map.get(c).intValue())
                    formed--;

                l++;
            }
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
