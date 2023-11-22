// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class MinWindowSubstring {
    class Solution {
        public String minWindow(String s, String t) {
            int sLen = s.length();
            int tLen = t.length();
            String result = "";

            if(tLen > sLen)
                return result;

            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < tLen; i++){
                char c = t.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            int match = 0;
            int start = 0, end = 0;


            while(end < sLen){
                char in = ' ';
                if(end < sLen)
                    in = s.charAt(end);

                if(map.containsKey(in)){
                    int count = map.get(in);
                    count--;
                    map.put(in, count);
                    if(count == 0)
                        match++;
                }
                end++;

                while(match == map.size()){
                    if(match == map.size()){
                        String sub = s.substring(start, end);
                        if(result == ""){
                            result = sub;
                        }
                        else if(sub.length() < result.length()){
                            result = sub;
                        }
                    }

                    char out = s.charAt(start);
                    if(map.containsKey(out)){
                        int count = map.get(out);
                        count++;
                        map.put(out, count);
                        if(count == 1){
                            match--;
                        }
                    }
                    start++;
                }
            }
            return result;
        }
    }
}
