import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 76. Minimum Window Substring
 * Link: https://leetcode.com/problems/minimum-window-substring/description/
 */
public class MinimumWindowSubstring {
    /**
     * two pointer sliding window Solution
     * TC O(n + m) one pass of m (t string) and 2 pass of n (s string)
     * SC O(1) only 52 unique keys in hashmap
     */
    public String minWindow(String s, String t) {
        int n = s.length();

        int start = -1;
        int end = Integer.MAX_VALUE - 10;
        Map<Character, Integer> freq = new HashMap<>();

        //prepare frequency map from t string
        for (char c: t.toCharArray()) { // TC O(m) SC O(1) since unique chars are limited to 52 total chars
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int match = 0;
        // widen the search window using right pointer by processing incoming char
        for(int right = 0; right < n; right++) { //TC O(n) its actually 2 pass solution one by right and another by left pointer SC O(1)
            char in = s.charAt(right);

            if (freq.containsKey(in)) { // only when incoming char is present in t
                int count = freq.get(in);
                count--;
                freq.put(in, count); //reduce freq map for incoming char at right pointer

                if(count == 0) { //whenever we have all freq for the current char we mark a match
                    /* we only do this when count switches from 1 to 0, not <= 0, otherwise we will
                    have incorrect match count */
                    match++;
                }
            }

            if (match == freq.size()) { //when all chars from t are matched
                if (right - left < end - start){ //if current window is smaller than previous solution window
                    end = right;
                    start = left;
                }

                /* Once all matches are found through right pointer, we want to move left point to shrink the window
                to find a possible smaller window. Process the outgoing char until we still have all chars from t matched */
                while (match == freq.size()) {
                    char out = s.charAt(left);
                    left++;

                    if (freq.containsKey(out)) {
                        int count = freq.get(out);
                        count++;
                        freq.put(out, count);

                        /* When count for current outgoing char flips from 0 to 1 (not > 0) we can say that we have one less
                        match in our new window due to outgoing char*/
                        if (count == 1) {
                            match--; // NOTE while condition mutated
                        }
                    }

                    /* As long as all chars from t are matched even after removing outgoing char and current window is smaller
                    than previous window length we can update our resultant start and end pointers*/
                    if (match == freq.size() && right - left < end - start){
                        end = right;
                        start = left;
                    }
                }
            }
        }

        /* no match found then return empty, otherwise substring between start and end */
        return start == -1 ? "" : s.substring(start, end + 1);
    }
}
