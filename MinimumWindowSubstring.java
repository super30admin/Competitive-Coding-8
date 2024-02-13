/*
* Time Complexity: O(2m)
     m = length of string
* 
* Space Complexity: O(26) == O(1)
    hashmap of 26 characters
* 
*/

import java.util.HashMap;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hmap = new HashMap<>();

        int m = s.length(), n = t.length();

        if(m < n)
            return "";

        for(int index = 0; index < n; index++){
            char ch = t.charAt(index);

            hmap.put(ch, hmap.getOrDefault(ch, 0)+1);
        }

        int match = 0, start = 0, minLen = Integer.MAX_VALUE;

        int resStart = -1, resEnd = -1;

        for(int index = 0; index < m; index++){
            char ch = s.charAt(index);
            
            if(hmap.containsKey(ch)){
                hmap.put(ch, hmap.get(ch)-1);

                if(hmap.get(ch) == 0){
                    match++;
                }
            }

            if(match == hmap.size()){
                int length = index - start + 1;

                if(minLen > length){
                    minLen = length;
                    resStart = start;
                    resEnd = index;
                }

                while(start < m) {
                    char out = s.charAt(start);
                    start++;

                    if(hmap.containsKey(out)){
                        if(hmap.get(out) == 0){
                            hmap.put(out, 1);
                            match--;
                            break;
                        }
                        hmap.put(out, hmap.get(out)+1);
                    }

                    length = index - start + 1;

                    if(minLen > length){
                        minLen = index - start + 1;
                        resStart = start;
                        resEnd = index;
                    }
                }
            }
        }

        if(resStart == -1){
            return "";
        }

        return s.substring(resStart, resEnd+1);
    }
}