
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Sliding windows
class Solution {
    public String minWindow(String s, String t) {
        if(s==null || t==null || s.length() < t.length())
            return "";
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
          char c = t.charAt(i);
          map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        
        int counter = map.size();
        int begin = 0;
        int end = 0;
        int head = 0;
        
        int length = Integer.MAX_VALUE;

        
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1); 
                if(map.get(c) == 0) 
                    counter--; //counter -- indicates we have found atleast one element from the substring. 
            }
            end++;
            
            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0) {
                        counter++;
                    }
                }
                if(end - begin < length){
                    length = end - begin;
                    head = begin;
                }
                begin++;
            }    
        }
        
        if(length == Integer.MAX_VALUE) 
            return "";
        return s.substring(head, head+length);
    }
}