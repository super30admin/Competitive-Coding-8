// Time Complexity :O(s+t)
// Space Complexity :O(s+t) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here  with comments explaining your approach
class Solution {
  public String minWindow(String s, String t) {
    if (s == null || t == null)
      return "";

    HashMap<Character, Integer> required = new HashMap<Character, Integer>();

    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      required.put(c, required.getOrDefault(c, 0) + 1);
    }

    HashMap<Character, Integer> count = new HashMap<Character, Integer>();
    int left = 0, right = 0, formed = 0, p1 = -1, p2 = -1;
    int min_len = Integer.MAX_VALUE;

    while (right < s.length()) {
      char c = s.charAt(right);

      count.put(c, count.getOrDefault(c, 0) + 1);
      if (required.containsKey(c) && required.get(c).intValue() == count.get(c).intValue()) {
        formed++;
      }

      while (formed == required.size() && left <= right) {
        if (right - left + 1 < min_len) {
          p1 = left;
          p2 = right;
          min_len = right - left + 1;
        }
        c = s.charAt(left);
        count.put(c, count.get(c) - 1);
        if (required.containsKey(c) && required.get(c).intValue() > count.get(c).intValue()) {
          formed--;
        }
        left++;
      }
      right++;
    }

    if (min_len == Integer.MAX_VALUE) {
      return "";
    }

    return s.substring(p1, p2 + 1);
  }
}