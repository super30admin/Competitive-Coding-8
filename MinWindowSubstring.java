class Solution {
    //Time Complexity:O(n)
    //Space Complexity:O(1)
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() > s.length())
            return "";
        
        HashMap<Character, Integer> tMap = new HashMap<>();
        int count = 0; // keeps track of how many letters have reached required count
        
        // populate the tMap
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        
        String ans = "";
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // check the letter against the map
            char c = s.charAt(i);
            if (tMap.containsKey(c)) {
                int curVal = tMap.get(c);
                curVal--;
                if (curVal == 0) {
                    count++;
                }
                tMap.put(c, curVal);
                
                // If we've found all required characters
                if (count == tMap.size()) {
                    // Try to minimize the window by moving start pointer
                    while (count == tMap.size()) {
                        char rc = s.charAt(start);
                        if (tMap.containsKey(rc)) {
                            int rcVal = tMap.get(rc);
                            rcVal++;
                            tMap.put(rc, rcVal);
                            
                            // If this character is no longer satisfied
                            if (rcVal > 0) {
                                count--;
                            }
                        }
                        start++;
                    }
                    
                    // Capture the current window (need to adjust start since we already incremented it)
                    String newWindow = s.substring(start - 1, i + 1);
                    if (ans.length() == 0 || newWindow.length() < ans.length()) {
                        ans = newWindow;
                    }
                }
            }
        }
        
        return ans;
    }
}
