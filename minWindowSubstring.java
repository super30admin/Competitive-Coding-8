// Time Complexity = O(m+n)
// Space Complexity = O(m), where m is the length of string s, used in stringBuilder,
// also for map (but since its only 26 characters we can consider it as constant)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0|| t.length() > s.length()) return "";
        int m = s.length();
        int n = t.length();
        int min = Integer.MAX_VALUE;
        int slow = 0;       //slow pointer
        int matched = 0;    // to check if the matched values are equal to t.length
        int startIdx=0, endIdx=-1;   // these variables will maintain start and end of the valid min substring

        // We maintain a map to store chars in string t
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c , 0) + 1);
        }

        // We will use a sliding window to check the min substring matched
        // here i will act as the fast pointer, and we create a slow pointer which moves with a
        for (int i=0; i<m; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                count--;
                map.put(c, count);

                if (count == 0) {
                    // found all the occurances of the character
                    matched++;
                }
            }

            // check if matched equals to size of the map, if yes then update the pointers and minimun
            while (matched == map.size()) {
                if (i-slow+1 < min) {
                    startIdx=slow;
                    endIdx=i;
                    min = i-slow+1;
                }

                char out = s.charAt(slow);
                if (map.containsKey(out)) {
                    int count = map.get(out);
                    count++;
                    map.put(out, count);

                    if (count == 1) {
                        matched--;
                    }
                }

                slow++;
            }
            // we skip characters that we dont need (not in map)
        }

        StringBuilder sb = new StringBuilder();
        for (int i = startIdx; i <= endIdx; i++) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}