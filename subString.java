// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
  public String minWindow(String s, String t) {

      if (s.length() == 0 || t.length() == 0) {
          return "";
      }
      
      Map<Character, Integer> mapT = new HashMap<>();
      
      for (int i = 0; i < t.length(); i++) {
          int count = mapT.getOrDefault(t.charAt(i), 0);
          mapT.put(t.charAt(i), count + 1);
      }
      
      int required = mapT.size();
      int l = 0, r = 0;
      int formed = 0;

      Map<Character, Integer> windowCounts = new HashMap<>();

      int[] ans = {-1, 0, 0};

      while (r < s.length()) {
          char c = s.charAt(r);
          int count = windowCounts.getOrDefault(c, 0);
          windowCounts.put(c, count + 1);

          if (mapT.containsKey(c) && windowCounts.get(c).intValue() == mapT.get(c).intValue()) {
              formed++;
          }

          while (l <= r && formed == required) {
              c = s.charAt(l);
              if (ans[0] == -1 || r - l + 1 < ans[0]) {
                  ans[0] = r - l + 1;
                  ans[1] = l;
                  ans[2] = r;
              }

              windowCounts.put(c, windowCounts.get(c) - 1);
              if (mapT.containsKey(c) && windowCounts.get(c).intValue() < mapT.get(c).intValue()) {
                  formed--;
              }

              l++;
          }

          r++;   
      }

      return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
  }
}