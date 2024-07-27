// Time Complexity : O(n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
  public String minWindow(String s, String t) {
    //Edge cases
    if(s == null || t == null || t.length() > s.length()) return "";

    Map<Character, Integer> tMap = new HashMap<>();
    for(char c: t.toCharArray()) {
      tMap.put(c, tMap.getOrDefault(c, 0)+1);
    }

    int left =0;
    int right = 0;
    int required = t.length();
    int minLength = Integer.MAX_VALUE;
    int minStart = 0;
    while(right < s.length()) {
      char current = s.charAt(right);
      if(tMap.containsKey(current)) {
        if(tMap.get(current) > 0) {
          required--;
        }
        tMap.put(current,tMap.get(current)-1);
      }

      while(required == 0) {
        if((right -left+1) < minLength) {
          minLength = right-left+1;
          minStart = left;
        }

        char leftChar = s.charAt(left);
        if(tMap.containsKey(leftChar)) {
          tMap.put(leftChar, tMap.get(leftChar) +1);
          if(tMap.get(leftChar) > 0) {
            required++;
          }
        }
        left++;
      }
      right++;
    }
    return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
  }
}