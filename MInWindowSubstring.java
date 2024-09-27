
// Time Complexity :  O(N + M) maze dimensions
// Space Complexity : O(N) total elements in the pattern string
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {
    public String minWindow(String s, String t) {
        //edge cases
        if(t == null ||t.length() == 0) return "";
        if(t.length() > s.length() ) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        //freq map
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int begin = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        int head = 0;
        int match = 0;
        //logic
        while(end < s.length()){ 
            //in
            char c = s.charAt(end);//A
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1); //freq reduced
                if(map.get(c) == 0) match++; 
            }
            
            while(match == map.size()){ //end = 5
                if(end - begin < len) {
                    len = end-begin+1;
                    head = begin;
                } //5
                char out = s.charAt(begin);
                if(map.containsKey(out)){
                    map.put(out, map.get(out) + 1); //one of the matched chars
                    if(map.get(out) > 0) match--;
                }
                begin++;
            }
            end++;
        }
        
        if(len == Integer.MAX_VALUE) return "";
        return s.substring(head, head + len);
    }
}