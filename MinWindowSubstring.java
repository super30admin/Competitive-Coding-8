
// Time Complexity : O(S+T)
// Space Complexity : O(T)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Using sliding window approach with two pointers start and end
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() ==0){
            return "";
        }

        HashMap<Character,Integer> map = new HashMap<>();
        // Adding all chars in the String t to a map along with its frequency
        for(char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int matched =0;
        // one pointer to keep track of the window
        int start = 0;
        int minLen = s.length() +1;
        int substr = 0;

        // another pointer to iterate the string s and check for the chars
        for(int end=0;end< s.length();end++){

            char in =s.charAt(end);

            if(map.containsKey(in)){
                // if incoming char is found in map, decrement its count in map
                map.put(in, map.get(in)-1);
                // if incoming char frequency is 0 in the map, then we found a match so increment matched
                if(map.get(in) == 0){
                    matched++;
                }
            }

            // matched is same as map size
            while(matched == map.size()){
                // check the minLength
                if(minLen > end-start+1){
                    minLen = end-start+1;
                    //store the start in a temp pointer
                    substr = start;
                }
                // remove the char from the sliding window and increment start
                char out = s.charAt(start++);
                if(map.containsKey(out)){
                    // check if out char frequency is 0 then decrement matched
                    if(map.get(out) == 0) matched--;
                    // increment count in map as the char is removed from the sliding window.
                    map.put(out, map.get(out)+1);
                }
            }
        }

        return minLen > s.length() ? "" : s.substring(substr, substr + minLen);

    }
}