
// Time Complexity : O(s.length * min(substring length))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++) { // taking frequencies of every character in t
            char curr = t.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0)+1);
        }
        String str = "";
        int slow = 0;
        int match = 0;
        // whenever the count on any character from 1 - 0, the match increases by 1
        // else if the count goes from 0 - 1, then match descreases
        // when we are on the window with all the characters from map
        // we shrink the window and until all the characters from t are present, we keep taking a snapshot of it for result
        // finally the min substring is returned with all the characters from t at least present once in substring
        for(int fast =0;fast<s.length();fast++) {
            char in = s.charAt(fast);
            if(map.containsKey(in)) {
                int inCount = map.get(in)-1;
                map.put(in, inCount);
                if(inCount == 0) match++;
            }
            while(match == map.size()) {
                if(str.length() == 0 || str.length() >= fast-slow+1) {
                    str = s.substring(slow, fast+1);
                }

                char out = s.charAt(slow);
                slow++;

                if(map.containsKey(out)) {
                    int outCount = map.get(out)+1;
                    map.put(out, outCount);

                    if(outCount == 1) {
                        match--;
                        break;
                    }

                }

            }

        }
        return str;
    }
}