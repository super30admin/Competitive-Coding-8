// Problem1 https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

// Time Complexity : O(n) 
// Space Complexity : O(1) i.e., alphabets
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, create a frequency map for t. While iterating thorugh s, initialize left and right as 0, and start index as 0, min as max_value and required
 * as length as the t. While right lessthan length if s, take char at right and if it is in map reduce count by 1 and if count>=0, reduce required by 1
 * while required is 0, if right-left+1 is lessthan min then take min as right-left+1 and startindex as 1. and take char at left and check if its in
 * hashmap, if yes increase count by 1 and if count >0 then increase required by 1, increase left for this while and increase right for outer while.
 * Finally return substring from startindex to min length.
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || s.isEmpty() || t.isEmpty()) {
            return "";
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int left = 0, right = 0, min = Integer.MAX_VALUE, startIndex = 0;
        int required = t.length();
        while(right<s.length()){
            char ch = s.charAt(right);

            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)>=0){
                    required--;
                }
            }
            while(required==0){
                if(right-left+1<min){
                    min = right-left+1;
                    startIndex = left;
                }
                char c = s.charAt(left);
                if(map.containsKey(c)){
                    map.put(c, map.get(c)+1);
                    if(map.get(c)>0){
                        required++;
                    }
                }
                left++;
            }
            right++;
        } 
        if(min == Integer.MAX_VALUE) return "";
        return s.substring(startIndex, startIndex+min);
    }
}