import java.util.HashMap;
import java.util.Map;

/**
 * Time complexity : O(m +n) m is length of s and n is length of t
 * Space complexity : O(1)
 * Did this code successfully run on Leet code : Yes
 * Any problem you faced while coding this : No
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String min = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(min);
    }
    private static String minWindow(String s, String t) {
        /** base condition
        * if any of the input strings is null or
        * if the length of s string is less than t string (then there is no point in searching for t's chars in s)
        * then we don't proceed further and return empty string */
        if(s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()){
            return "";
        }

        /* Map to store the character and its frequency from String t */
        Map<Character,Integer> map = new HashMap<>();

        /* Iterating over string t and storing the character and its frequency in the map */
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        /** match is used to check if we found all the characters from t in substring of s
         * Whenever the value of some character becomes zero from its initial value
         * then we increment match as we found the element from t in s as a match
         * If the value of match equals the size of map then it means that we found all the
         * characters from t in s in that window. Whenever, we are sliding the window and a
         * character from t in s moves out of the window then we increment the count of that character in
         * the map and if the value in the map becomes greater than 0 then we decrease the match value
         * as one of the matching characters moved out of the window */
        int match = 0;
        int windowLength = Integer.MAX_VALUE;
        int left = 0, right = 0; //Two pointers to move the sliding window, that is to capture the substring
        String result = "";

        while(left <= right && right < s.length()){
            char currentChar = s.charAt(right);
            if(map.containsKey(currentChar)){
                map.put(currentChar, map.get(currentChar) - 1);
                if(map.get(currentChar) == 0){
                    match++;
                }
            }
            while(match == map.size() && right - left + 1 >= t.length()){
                if(right - left + 1 < windowLength){
                    result = s.substring(left, right+1);
                    windowLength = right - left + 1;
                }

                char leftChar = s.charAt(left);
                if(map.containsKey(leftChar)){
                    map.put(leftChar, map.get(leftChar) + 1);
                    if(map.get(leftChar) > 0){
                        match--;
                    }
                }
                left++;
            }
            right++;
        }
        return result;
    }
}
