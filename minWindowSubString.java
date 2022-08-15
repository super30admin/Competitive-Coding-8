// Time Complexity : O(m+n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()){
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        //
        for(int j = 0; j < t.length(); j++){
            char i = t.charAt(j);
            if(!map.containsKey(i)){
                map.put(i,0);
            }
            map.put(i, map.get(i) + 1);
        }
        int match = 0;
        int temp = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(i <=j && i < s.length()){
            if(match == map.size()){
                temp = Math.min(temp, j-i);
                if(temp == j-i){
                    sb = new StringBuilder(s.substring(i,j));
                } 
            }
            if(i != j && match == map.size() || j == s.length()){
                char k = s.charAt(i);
                if(map.containsKey(k)){
                    if(map.get(k) == 0){
                        match--;
                    }
                    map.put(k,map.get(k) + 1);
                }
                i++;
            } else{
                char k = s.charAt(j);
                if(map.containsKey(k)){
                    if(map.get(k) == 1){
                        match++;
                    }
                    map.put(k,map.get(k) - 1);
                }
                j++;
            }
        }
        return sb.toString();
    }
}