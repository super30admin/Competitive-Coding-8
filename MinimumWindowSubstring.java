//TC:O(m+n), m-> t.length(), n : s.length()
//SC:O(m)
//Did it run successfully on Leetcode?:Yes
class Solution {
    public String minWindow(String s, String t) {
     HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
     for (char c: t.toCharArray())
     {
         tMap.put(c, tMap.getOrDefault(c, 0) + 1);
     }
     int result[] = {-1, 0, 0};
     int left = 0;
     int right = 0;
     int required = tMap.size();
     int expected = 0;
     
    
     HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
     while ( right < s.length() )
     {
         char c = s.charAt(right);
         sMap.put(c, sMap.getOrDefault(c, 0) + 1);
         
         if (tMap.containsKey(c) && tMap.get(c).intValue()  == sMap.get(c).intValue())
         {
                 expected++;
         }
         while ( expected == required && left <= right)
         {
             if ( result[0] == -1 || result[0] > (right - left + 1) )
             {
                 result[0] = right - left + 1;
                 result[1] = left;
                 result[2] = right;
             }
             c = s.charAt(left);
             sMap.put(c, sMap.getOrDefault(c, 0) - 1);
             if (tMap.containsKey(c) && sMap.get(c).intValue() < tMap.get(c).intValue() )
             {
                 expected--;
             }
             left++;
             
         }
         right++; 
     }
    return result[0] == -1? "" : s.substring(result[1], result[2] + 1);
    }
}
