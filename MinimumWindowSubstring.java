// Time Complexity : O(m+n) m = length of string s, n = length of string t
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// This method finds the minimum window substring in s that contains all characters of t.
// It uses a hashmap to count the characters in t and a sliding window approach to find the smallest valid substring, updating the minimum length and starting index when a valid window is found.
// If no valid window is found, it returns an empty string; otherwise, it returns the smallest window.


class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t== null || t.length()> s.length()){
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i< t.length(); i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int min = Integer.MAX_VALUE;
        int cnt = map.size();
        int index = -1;
        int start =0, end=0;

        while(end < s.length()){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)==0){
                    cnt--;
                }
            }
            while(cnt == 0){
                int len = end-start+1;
                if(len < min){
                    min = len;
                    index = start;
                }
                ch = s.charAt(start);
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch)+1);
                    if(map.get(ch)==1){
                        cnt++;
                    }
                }
                start++;
            }
            end++;
        }
        if(index==-1){
            return "";
        }
        return s.substring(index, index+min);
    }
}
