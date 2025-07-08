/*
Approach : Two pointers
Time: O(m + n)	One pass over t + sliding window on s
Space: O(k)	Hash maps store frequency counts of unique chars
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
import java.util.HashMap;
public class MinimumWindowSubstring_LC_76 {
    public String minWindow(String s, String t) {
        if(s.length() ==0 || t.length() == 0 || s.length() < t.length())
            return "";
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i =0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0) +1);
        }
        int match = 0;
        int temp = Integer.MAX_VALUE;
        // BigInteger temp = new BigInteger("999999999999999999"); ////some random high number
        String output = "";

        int left = 0, right = 0;
        while(left <= right && left < s.length()) {
            if(match == map.size()){ //we found substring
                temp = Math.min(temp, right-left); //preserve minimum window
                if(temp == right-left) {
                    output = s.substring(left, right);
                }
            }
            if((left != right && map.size() == match) || right == s.length()) {
                if(map.containsKey(s.charAt(left))){
                    if(map.get(s.charAt(left)) == 0) {
                        match--;
                    }
                    map.put(s.charAt(left), map.getOrDefault(s.charAt(left),0) +1);
                }
                left++;
            } else{
                if(map.containsKey(s.charAt(right))){
                    if(map.get(s.charAt(right)) == 1) {
                        match++;
                    }
                    map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0) -1);
                }
                right++;
            }

        }
        return output;
    }
}