// Time Complexity : O(s+t)
// Space Complexity : O(t)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length() || s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int start = 0;
        int end = 0;
        int i = 0;
        int j = 0;
        int minLength = s.length() + 1;
        int match = 0;
        boolean found = false;
        int required = map.size();
        while (j < s.length()) {
            char incoming = s.charAt(j++);
            if (map.containsKey(incoming)) {
                map.put(incoming, map.get(incoming) - 1);
                if (map.get(incoming) == 0) {
                    match = match + 1;
                }
            }

            while (match == required) {
                if (j - i < minLength) {
                    start = i;
                    end = j;
                    minLength = j - i;
                    found = true;
                }
                char outgoing = s.charAt(i++);
                if (map.containsKey(outgoing)) {
                    map.put(outgoing, map.get(outgoing) + 1);
                    if (map.get(outgoing) > 0) {
                        match = match - 1;
                    }
                }
            }

        }

        if (found) {
            return s.substring(start, end);
        }
        return "";
    }
}