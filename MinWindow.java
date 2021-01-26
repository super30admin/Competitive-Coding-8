// Time Complexity : O(S + T)
// Space Complexity : O(S + T)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length() == 0 || t.length() == 0) return " ";
        
        HashMap<Character, Integer> dict = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++) {
            dict.put(t.charAt(i), dict.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        int required = dict.size();
        int l = 0;
        int r = 0;
        int formed = 0;
        int[] ans = {-1, 0, 0};
        
        HashMap<Character, Integer> window = new HashMap<>();
        
        while(r < s.length()) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if(dict.containsKey(c) && window.get(c).intValue() == dict.get(c).intValue() ) {
                formed++;
            }
            
            while(l <= r && formed == required) {
                
                c = s.charAt(l);
                if(ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                window.put(c, window.getOrDefault(c, 0) - 1);
                
                if(dict.containsKey(c) && window.get(c).intValue() < dict.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        if(ans[0] == -1) {
            return "";
        } else {
            return s.substring(ans[1], ans[2] + 1);
        }
        
    }
}