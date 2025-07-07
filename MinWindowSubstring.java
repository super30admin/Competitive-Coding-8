// TC O(n)
// SC O(1) max 52 key in hashmap
class Solution {
    public String minWindow(String s, String t) {
        int windowLength = Integer.MAX_VALUE;
        int matchCount = 0;
        int windowStart = 0;
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
            }
            map.put(ch, map.get(ch) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (map.containsKey(currChar)) {
                int chCount = map.get(currChar);
                chCount--;
                map.put(currChar, chCount);
                if (chCount == 0) {
                    // Match++
                    matchCount++;
                }
            }

            while (matchCount == map.size() && windowStart < s.length()) {
                // we found a window update start end
                if (i - windowStart + 1 < windowLength) {
                    start = windowStart;
                    end = i;
                    windowLength = i - windowStart + 1;
                }

                char ch = s.charAt(windowStart);
                if (map.containsKey(ch)) {
                    int chCount = map.get(ch);
                    chCount++;
                    map.put(ch, chCount);
                    if (chCount > 0) {
                        matchCount--;
                    }
                }
                windowStart++;

            }
        }
        if (windowLength == Integer.MAX_VALUE)
            return "";
        return s.substring(start, end + 1);
    }
}