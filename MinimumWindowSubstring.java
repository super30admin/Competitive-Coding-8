/*
* Approach: 
 - Store the characters and freq from t in the map
 - Start iterating characters from s string and go until matchCount becomes the same as t.length()
    - matchCount is increased only when the character exists in the map and if the freq of the character is either greater or equal to zero after reducing the frequency
    - if the matchCount is equals to t.length(), that means we have all the characters we need in the window so check if the windowSize is less than the current minLen variable(as we want min window) if yes, store the starting index in start variable and update the minLength
    - to make sure we have found the min window, start moving the left pointer, until the matchCount is the same as t.length()
        - check the char at left pointer, see if it exists in the map, if it does, increase the freq of the map and if the freq is greater than 0, reduce the match count and increment the left pointer
        - why greater than 0? Because when the freq becomes -ve, we are not increasing the matchcount, so while decreasing the match count we need to make sure the match count is decreased only when the freq is in positive
 - once we reach the length of s string, we compare 
    - if the minLen == infinity, return empty string
    - else return substring of s from start to start + minLen
TC: O(m+n) -> m = s.length() & n = t.length() -> iterate n elements to add it to the map and iterate m elements to find the min window substring
SC: O(n) -> map to store characters from t string
*/
class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length() || s == null || t == null)
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int match = 0;

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0)
                    match++;
            }

            while(match == t.length()){
                if(minLen > right - left + 1){
                    minLen = right - left + 1; //1
                    start = left; //0
                }

                char l = s.charAt(left);
                if(map.containsKey(l)){
                    map.put(l, map.get(l) + 1);
                    if(map.get(l) > 0){
                        match--;
                    }
                }
                left++;
            }
        }
        if(minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(start, start + minLen);
    }
}

