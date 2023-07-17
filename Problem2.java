// Time Complexity :O(n+m) where n is the length of the s string and m is the length of the t string
// Space Complexity :O(m) where m is the length of the t string
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

import java.util.HashMap;

class MinWindowSubstring {
    public String minWindow(String s, String t) {
        String result = new String();
        if(t.length() > s.length()){
            return result;
        }

        int slen = s.length();
        int tlen = t.length();

        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i< tlen; i++){
            Character c = t.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        int left = 0;
        int start = 0;
        int end = 0;
        int min = 100001;
        int right = 0;

        while(right< slen && left < slen){
            //slide right to find a valid window
            while(right < slen && match != frequencyMap.size()){
                //in
                Character in = s.charAt(right);
                if(frequencyMap.containsKey(in)){
                    int count = frequencyMap.get(in) - 1;
                    frequencyMap.put(in, count);
                    if(count == 0){
                        match++;
                    }
                }
                right++;
            }

            //note: right is one step ahead
            //slide left to find a smaller valid window
            while(left < slen && match == frequencyMap.size()){
                if(right - left< min){
                    start = left;
                    end = right-1;
                    min = end - start + 1;
                }
                //remove the left char
                Character out = s.charAt(left);
                if(frequencyMap.containsKey(out)){
                    int count = frequencyMap.get(out) + 1;
                    frequencyMap.put(out, count);
                    if(count == 1){
                        match--;
                    }
                }
                left++;
            }
        }
        return min == 100001 ? ""
                : s.substring(start, end+1);
    }
}
