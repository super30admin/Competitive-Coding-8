// Time Complexity : O(n + m) where n & m are the lengths of input string s & t
// Space Complexity : O(n + m)
// Did this code successfully run on Leetcode (76): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        
        // Dictionary which keeps a count of all the unique characters in t
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = dict.getOrDefault(c, 0) + 1;
            dict.put(c, count);
        }
        
        // Number of unique characters in t, which need to be present in the desired window
        int required = dict.size();
        
        // Dictionary which keeps a count of all the unique characters in the current window
        Map<Character, Integer> windowCounts = new HashMap<>();
        
        // left and right pointers
        int l = 0; int r = 0; 
        int formed = 0;
        
        // ans list of the form (window length, left, right)
        int ans[] = {-1, 0, 0};
        
        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0) + 1;
            windowCounts.put(c, count);
            
             // If the frequency of the current character added equals to the desired count in t then increment the formed count by 1
            if (dict.containsKey(c) && windowCounts.get(c).intValue() == dict.get(c).intValue()) formed++;
            
            // Try and contract the window till the point where it ceases to be 'desirable'
            while (formed == required && l <= r) {
                c = s.charAt(l);
                
                if (ans[0] == -1 || r-l+1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                
                // The character at the position pointed by the `Left` pointer is no longer a part of the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dict.containsKey(c) && windowCounts.get(c).intValue() < dict.get(c).intValue()) formed--; 
                
                // Move the left pointer ahead, this would help to look for a new window
                l++;
            }
            
            // Keep expanding the window once we are done contracting
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}