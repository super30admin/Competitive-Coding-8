//https://leetcode.com/problems/minimum-window-substring/
/*
Time: O(2M + N) where M = s.length() and N = t.length()
Space: O(N) for HashMap
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class MinWindowSubstring {

    public String minWindow(String s, String t) {

        if (s == null || t == null || s.isEmpty() || t.isEmpty())
            return "";

        Map<Character, Integer> map = new HashMap<>();
        // Populate the map using t
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = 0, count = map.size();
        int left = 0, right = s.length() - 1; // to keep track of the minimum substring positions
        int min = s.length(); // If there is a substring in s, it will be guaranteed to be lower than s.length
        boolean found = false;

        while (j < s.length()) {
            char endChar = s.charAt(j++);
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0)
                    count--; // statisfied finding a char, so decrement

            }

            if (count > 0)
                continue; // We have not found a min window substr yet

            // remove extra unnecessary chars in the prefix
            while (count == 0) // We have found a substr, move i forward until count>0 again
            {
                char startChar = s.charAt(i++);

                // do opposite of previous block.
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0)
                        count++;
                }

            }

            if (j - i < min) // j-i is the length of our substring
            {
                left = i;
                right = j;
                min = j - i;
                found = true; // our final result will not be an empty string
            }
        }

        return !found ? "" : s.substring(left - 1, right); // left-1, right-1 inclusive

    }

}
