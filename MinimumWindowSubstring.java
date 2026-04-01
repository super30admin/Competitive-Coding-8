// Time Complexity : O(m + n), where m,n = lengths of the strings respectively
// Space Complexity : O(1) since O(n), n=26 alphabet, so constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to use 2 pointers fast and slow to form the sliding window.But before that, we store the characters
and their frequencies of letter t for faster access in a map. Now, we iterate the fast pointer on s and at any time
if the incoming character exists in the map, we reduce its frequency and whenever frequency becomes 0, we increment
the match denoting we got match for that character. Whenever match count equals to map size, we need to check the
length of the window formed until now.If we find a shorter length, we update the length value and start value to slow.
Now,we need to find if there exists any shorter length by shrinking the window, so we check the outgoing character and
if it exists in the map, we increment the frequency,if freq is 1, we decrement match.We also increment slow pointer as
we are recomputing the window length.Finally, we return the substring of start index to formed length.
 */
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for(char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int slow = 0 , start = 0 , match = 0;
        int minLen = Integer.MAX_VALUE;

        for(int fast = 0 ; fast < s.length() ; fast++) {
            char inChar = s.charAt(fast);
            if(tMap.containsKey(inChar)) {
                int frq = tMap.get(inChar);
                frq--;
                tMap.put(inChar, frq);

                if(frq == 0)
                    match++;
            }

            if(match != tMap.size())
                continue;

            while(match == tMap.size()) {
                if(minLen > fast - slow + 1) {
                    minLen = fast - slow + 1;
                    start = slow;
                }

                char outChar = s.charAt(slow);
                slow++;

                if(tMap.containsKey(outChar)) {
                    int frq = tMap.get(outChar);
                    frq++;
                    tMap.put(outChar, frq);

                    if(frq == 1)
                        match--;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}