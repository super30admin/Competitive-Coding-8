//Time complexity: O(|S| + |T|)
//Space complexity: O(|S| + |T|)
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        //dictionary to keep count of all the unique characters in t.
        Map<Character, Integer> mapT = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            int count = mapT.getOrDefault(t.charAt(i), 0);
            mapT.put(t.charAt(i), count + 1);
        }
        
        int required_size = mapT.size();
        int left = 0;
        int right = 0;
        //to keep track of how many unique characters in t
        //present in the current window
        int window_size = 0;
        
        
        //dictionary to keep count of all the unique characters in current window.
        Map<Character, Integer> windowMap = new HashMap<>();
        int[] ans = {-1, 0, 0};
        while(right < s.length()) {
            char c = s.charAt(right);
            int count = windowMap.getOrDefault(c, 0);
            windowMap.put(c, count + 1);
            
            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if(mapT.containsKey(c) && windowMap.get(c).intValue() == mapT.get(c).intValue()) {
                window_size++;
            }
            
            while(left <= right && window_size == required_size) {
                c = s.charAt(left);
                // Save the smallest window until now.
                  if (ans[0] == -1 || right - left + 1 < ans[0]) {
                      ans[0] = right - left + 1;
                      ans[1] = left;
                      ans[2] = right;
                  }
                
                // The character at the position pointed by the
                // Left pointer is no longer a part of the window.
              windowMap.put(c, windowMap.get(c) - 1);
              if (mapT.containsKey(c) && windowMap.get(c).intValue() <  mapT.get(c).intValue()) {
                  window_size--;
              }
                
               left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);

    }
}