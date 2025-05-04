import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        HashMap<Character, Integer> tmap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> smap = new HashMap<>();
        int left = 0, right = 0;
        int formed = 0;
        int required = tmap.size();
        int[] ans = {Integer.MAX_VALUE, 0, 0}; // size, left, right

        while (right < s.length()) {
            char c = s.charAt(right);

            smap.put(c, smap.getOrDefault(c, 0) + 1);
            if (tmap.containsKey(c) && tmap.get(c).equals(smap.get(c))) {
                formed++;
            }

            while (left <= right && formed == required) {
                if ((right - left + 1) < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                c = s.charAt(left);

                smap.put(c, smap.getOrDefault(c, 0) - 1);

                if (tmap.containsKey(c) && tmap.get(c) > smap.get(c)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        if (ans[0] == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(ans[1], ans[2] + 1);
    }
}

//TC: O(m+n), SC: O(1)
