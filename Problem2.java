
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem2 {
    public String minWindow(String s, String t) {
        String result = "";
        int minLength = Integer.MAX_VALUE;
        int m = s.length();
        int n = t.length();

        // Map to store the frequency of characters in t
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            charMap.put(t.charAt(i), charMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int required = charMap.size();
        int left = 0;
        int match = 0;

        for (int right = 0; right < m; right++) {
            char currChar = s.charAt(right);

            // If the current character is in t, decrease its frequency in charMap
            if (charMap.containsKey(currChar)) {
                charMap.put(currChar, charMap.get(currChar) - 1);
                if (charMap.get(currChar) == 0) {
                    match++;
                }
            }

            // If we have matched all characters in t, try to shrink the window
            while (match == required && left <= right) {
                int windowLength = right - left + 1;
                if (windowLength < minLength) {
                    minLength = windowLength;
                    result = s.substring(left, right + 1);
                }

                // Shrink the window by moving left pointer
                char leftChar = s.charAt(left);
                if (charMap.containsKey(leftChar)) {
                    charMap.put(leftChar, charMap.get(leftChar) + 1);
                    if (charMap.get(leftChar) ==1) {
                        match--;
                    }
                }
                left++;
            }
        }

        return result;
    }
}

