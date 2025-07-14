// Time Complexity: O(s + t)
// Space Complexity: O(t)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : YES

class MinWindowSubString_LC76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || s.length() == 0 || t.length() == 0) return "";

        int sLen = s.length();
        int tLen = t.length();

        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        int[] minWindow = {0, Integer.MAX_VALUE};
        int startIndex = 0;

        for (int endIndex = 0; endIndex < sLen; endIndex++) {
            char ch = s.charAt(endIndex);
            if (charCount.containsKey(ch) && charCount.get(ch) > 0) {
                tLen--;
            }
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);

            if (tLen == 0) {
                while (true) {
                    char charAtStart = s.charAt(startIndex);
                    if (charCount.containsKey(charAtStart) && charCount.get(charAtStart) == 0) {
                        break;
                    }
                    charCount.put(charAtStart, charCount.getOrDefault(charAtStart, 0) + 1);
                    startIndex++;
                }

                if (endIndex - startIndex < minWindow[1] - minWindow[0]) {
                    minWindow[0] = startIndex;
                    minWindow[1] = endIndex;
                }

                charCount.put(s.charAt(startIndex), charCount.getOrDefault(s.charAt(startIndex), 0) + 1);
                tLen++;
                startIndex++;
            }

        }

        return minWindow[1] >= s.length() ? "" : s.substring(minWindow[0], minWindow[1] + 1);
    }
}