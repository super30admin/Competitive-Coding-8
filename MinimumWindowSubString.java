// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        int i = 0;
        int j = 0;
        int requiredCount = t.length();
        int minWindowSize = Integer.MAX_VALUE;
        int start = 0;

        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int k = 0; k < t.length(); k++) {
            char c = t.charAt(k);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        while (j < s.length()) {
            char c = s.charAt(j);
            if (tMap.containsKey(c)) {
                int count = tMap.get(c);
                if (count > 0) {
                    requiredCount--;
                }
                tMap.put(c, count - 1);

                while (requiredCount == 0) {
                    int currentWindowSize = j - i + 1;
                    if (currentWindowSize < minWindowSize) {
                        minWindowSize = currentWindowSize;
                        start = i;
                    }
                    char iChar = s.charAt(i);
                    if (tMap.containsKey(iChar)) {
                        tMap.put(iChar, tMap.get(iChar) + 1);
                        if (tMap.get(iChar) > 0)
                            requiredCount++;
                    }
                    i++;
                }
            }
            j++;
        }

        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start, start + minWindowSize);

    }
}