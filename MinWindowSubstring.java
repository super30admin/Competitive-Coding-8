/*
 * TC: O(m + n)
 * SC: O(128)
 */
public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        int[] tMap = new int[128];
        int startIndex = -1;
        int minLen = 1000000001;
        int matchCount = 0;
        int l = 0, r = 0;
        int m = s.length();
        int n = t.length();
        //compute tMap
        for (char c : t.toCharArray()) tMap[c]++;
        while (r < m) {
            char next = s.charAt(r);
            tMap[next]--;
            // if, after decreasing next's count in tMap the count is still >= 0
            // we have a match, increment matchCount
            if (tMap[next] >= 0) matchCount++;
            // when the number of matches == t.length, we have a valid answer
            // capture it and shrink the window until possible
            while (matchCount == n) {
                // capture the minLen and the startIndex
                if (minLen > r - l + 1) {
                    minLen = r - l + 1;
                    startIndex = l;
                }
                // shrink the window by removing the left character
                char last = s.charAt(l);
                tMap[last]++;
                // if the count becomes positive we have lost a match
                if (tMap[last] > 0) matchCount--;
                l++;
            }
            r++;
        }
        //if we found a valid substring, return it, else return empty string
        return minLen == 1000000001 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}