public class MinimumWindowSubstring {

    // TC: O(M + N) where M is length of string 's' and N is length of string 't'
    // SC: O(1)
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] map = new int[128];
        int required = 0;
        for (char c : t.toCharArray()) {
            map[c]++;
            if (map[c] == 1) {
                required++;
            }
        }

        int l = 0, r = 0, minLen = Integer.MAX_VALUE;
        int start = 0;
        while (r < s.length()) {
            char incomingChar = s.charAt(r);
            map[incomingChar]--;
            if (map[incomingChar] == 0) {
                required--;
            }
            while (required == 0) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                char outgoingChar = s.charAt(l);
                map[outgoingChar]++;
                if (map[outgoingChar] == 1) {
                    required++;
                }
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
