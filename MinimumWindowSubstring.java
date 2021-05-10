//Approach - Sliding Window - store all the characters in t in the map
//           loop through all the characters in the s
//           decrement the match count if the map is key
//           when the count == 0, try to reduce the window space
//           to check if the t can be found within a minimal window
//Time Complexity - O(s + t) - where s - length of s, t - length of t
//Space Complexity - O(s + t)
class Solution {
  public String minWindow(String s, String t) {
    if(s == null || s.length() == 0 || t == null || t.length()== 0){
      return "";
    }

    Map<Character, Integer> map = new HashMap<>();
    for(int i=0; i<t.length(); i++){
      char ch = t.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0)+1);
    }

    int i=0, j=0, match = map.size();
    int left=0, right=s.length()-1, min = s.length();
    boolean found = false;

    while(j < s.length()){
      char ch = s.charAt(j++);
      if(map.containsKey(ch)){
        map.put(ch, map.get(ch)-1);

        if(map.get(ch) == 0){
          match--;
        }
      }

      if(match > 0){
        continue;
      }

      while(match == 0){
        char out = s.charAt(i++);

        if(map.containsKey(out)){
          map.put(out, map.get(out)+1);

          if(map.get(out) > 0){
            match++;
          }
        }

      }

      if((j-i) < min){
        left = i;
        right = j;
        min = j-i;

        found = true;
      }
    }

    return found? s.substring(left-1, right) : "";
  }
}
