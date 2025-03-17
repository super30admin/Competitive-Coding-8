// Time Complexity: O(m+n) where m is the length of s and n is the length of t
// Space Complexity: O(m+n) where m is the length of s and n is the length of t

import java.util.HashMap;
import java.util.Map;

class MinWindowSubstring {
    public String minWindow(String s, String t) {
        int sl = s.length();
        int pl = t.length();

        if(pl > sl){
            return "";
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            tMap.put(ch, tMap.getOrDefault(ch, 0)+1);
        }

        int requiredMatches = tMap.size();
        int match = 0;

        int wStart = 0, start = 0;;
        int minLen = Integer.MAX_VALUE;

        for(int wEnd = 0; wEnd < sl; wEnd++){
            char ch = s.charAt(wEnd);

            sMap.put(ch, sMap.getOrDefault(ch, 0)+1);

            if(tMap.containsKey(ch) && tMap.get(ch).equals(sMap.get(ch))){
                match++;
            }

            while(match == requiredMatches){

                if(wEnd-wStart+1 < minLen){
                    minLen = wEnd-wStart+1;
                    start = wStart;
                }
                char startChar = s.charAt(wStart);

                sMap.put(startChar, sMap.get(startChar)-1);

                if(tMap.containsKey(startChar) && sMap.get(startChar) < tMap.get(startChar)){
                    match--;
                }

                wStart++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
