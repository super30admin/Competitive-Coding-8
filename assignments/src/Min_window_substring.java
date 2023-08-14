import java.util.*;
// Approach: Use 2 hashmaps, one for storing frequencies of chars in t and second for storing char frequencies of our sliding window
// Expand window with right pointer, every time we find a window with same chars in both maps, contract the window to find the
// smallest possible window that has all the characters with exact frequencies as well
// Time: O(s + t)
// Space: O(s + t)
public class Min_window_substring {

    public String minWindow (String s, String t) {

        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> dictT = new HashMap();

        for (int i = 0; i<t.length(); i++) {
            char c = t.charAt(i);
            dictT.put(c, dictT.getOrDefault(i,0) + 1);
        }

        int required = dictT.size();
        int l = 0, r = 0;
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap();

        int[] ans = {-1, 0 , 0};

        while (r < s.length()) {
            char c = s.charAt(r);

            windowCounts.put(c, windowCounts.getOrDefault(c,0) + 1);

            if (dictT.containsKey(c) && dictT.get(c).intValue() == windowCounts.get(c).intValue()) {
                formed++;
            }

            // contract window until it ceases to be desirable
            while (l <= r && formed == required) {
                // save the smallest window uptil now
                if (ans[0] == -1 || r-l+1 < ans[0]) {
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}