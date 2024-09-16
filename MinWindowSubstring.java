import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    // Sliding window approach
    // TC: O(m) -> m - length of the string s
    // SC: O(1)
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length() || t.length() == 0) return "";

        // A map to hold the count of each character in t string
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        int charTLeft = t.length(); // a variable to track how many chars of t are yet to be matched

        // window related properties
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;

        while(end < s.length()) {
            char eChar = s.charAt(end);


            // Incoming character
            if(map.containsKey(eChar)) {
                int count = map.get(eChar);
                if(count > 0) {
                    charTLeft--;  // we found a match. Let's decrement the chars to match
                }
                map.put(eChar, count - 1);
            }
            end++;

            // since all the characters from t matched to whatever the window we have, need to find the possible smaller window
            while(charTLeft == 0){
                if(minLength > end - start) {
                    minLength = end - start; // resetting minLength to a smaller value
                    minStart = start;
                }

                // Outgoing character
                char sChar = s.charAt(start);
                if(map.containsKey(sChar)) {
                    int count = map.get(sChar);
                    if(count == 0) {
                        charTLeft++;
                    }
                    map.put(sChar, count + 1);
                }
                start++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? "" // we didn't find anything matching
                : s.substring(minStart, minStart + minLength);
    }
}
