public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> t_map = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = t_map.getOrDefault(t.charAt(i), 0);
            t_map.put(t.charAt(i), count + 1);
        }

        int required = t_map.size();
        int l = 0, r = 0;
        int formed = 0;

        Map<Character, Integer> s_map = new HashMap<Character, Integer>();

        int[] res = { -1, 0, 0 };

        while (r < s.length()) {
            char c = s.charAt(r);
            int count = s_map.getOrDefault(c, 0);
            s_map.put(c, count + 1);

            if (t_map.containsKey(c) && s_map.get(c).intValue() == t_map.get(c).intValue()) {
                formed++;
            }
            while (l <= r && formed == required) {
                c = s.charAt(l);
                if (res[0] == -1 || r - l + 1 < res[0]) {
                    res[0] = r - l + 1;
                    res[1] = l;
                    res[2] = r;
                }
                s_map.put(c, s_map.get(c) - 1);
                if (t_map.containsKey(c) && s_map.get(c).intValue() < t_map.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }

        return res[0] == -1 ? "" : s.substring(res[1], res[2] + 1);
    }
}

// Time Complexity - O(m+n)
// Space Complexity - O(1)