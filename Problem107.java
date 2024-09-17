// Time Complexity : O(m+n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        HashMap<Character, Integer> t_map = new HashMap<>();
        for(char c: t.toCharArray()){
            t_map.put(c, t_map.getOrDefault(c,0)+1);
        }
        HashMap<Character, Integer> s_map = new HashMap<>();
        int sat = 0;
        int len_t = t_map.size();
        int left = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        for(int right = 0;right<s.length(); right++){
            char c  = s.charAt(right);
            s_map.put(c,s_map.getOrDefault(c,0)+1);
            if(t_map.containsKey(c) && s_map.get(c).intValue() == t_map.get(c).intValue()){
                sat++;
            }
            while(sat == len_t){
                if ( right - left + 1 <len){
                    len = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                s_map.put(leftChar, s_map.get(leftChar)-1);
                if(t_map.containsKey(leftChar) && s_map.get(leftChar).intValue()< t_map.get(leftChar).intValue()){
                    sat--;
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
