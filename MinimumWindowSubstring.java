import java.util.HashMap;
import java.util.Map;

/*
Time Complexity : O(m) where m is length of string s
Space Complexity : O(n) for map, where n is the length of string t
Approach :
Using sliding window approach, we can have 2 pointers one to track incoming character and one to track outgoing
character. First, we need to create frequency map for chars in t string. Loop through each character in string s,
incoming char ->
if char in s is also present in t, reduce count. if count becomes 0, s has 1 character matching in t. Increment end pointer.
outgoing char ->
Remove one or more chars from start while the matchCount is not impacted.
Compare with min length and capture the new start and end.
if any character count becomes 1, that character is not matching, so  decrement matchCount. Increment start pointer.
Compare the new length with the min length and if it is less override min length and record start and end pointer.
*/

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tlen; i++) {
            char curr = t.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        int matchCount = 0;
        int end = 0;
        int start = 0;

        int minLength = slen + 1;
        int left = -1, right = -1;

        while (end < slen) {
            char incoming = s.charAt(end);
            // Move end pointer, add incoming character one by one
            if (map.containsKey(incoming)) {
                int count = map.get(incoming) - 1;
                map.put(incoming, count);
                if (count == 0) {
                    matchCount += 1;
                }
            }
            end++;

            // this will remove multiple chars from start if they are not in substring t
            // this will break as soon as it finds one character that is in
            while (matchCount == map.size()) {
                if (end - start < minLength) {
                    minLength = end - start;
                    left = start;
                    right = end;
                }
                char outgoing = s.charAt(start);
                if (map.containsKey(outgoing)) {
                    int count = map.get(outgoing) + 1;
                    map.put(outgoing, count);
                    if (count == 1) {
                        matchCount -= 1;
                    }
                }
                start++;
            }

        }

        if (left == -1)
            return "";
        return s.substring(left, right);
    }
}
