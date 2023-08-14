//Time Complexity : O(M) 
//Space Complexity : O(N) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Put the t in map with its character counts. Then iterate over s and reduce
 * the count for the character in map if it is present. Each time when count is
 * reduced, increment match count. If match count is equal to t size, then
 * calculate the size of the window by doing current index - start index + 1.
 * Then start removing one character at a time from start index. If character is
 * present in map, then update its count by +1 and if the existing count is 0,
 * that means all characters were used in earlier substring. So reduce the match
 * count. That means there is one char missing in the window now. return the
 * substring from calcuated start index to min length calculated.
 *
 */
class Solution {
    public String minWindow(String s, String t) {
        //null case
        if(s == null || s.isEmpty() || t == null || t.isEmpty()) return "";
        
        Map<Character, Integer> map = new HashMap<>();
        
        //add elements of T and its count in HashMap
        for(int i=0; i< t.length();i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        int i = 0, j = 0, count = map.size();
        int left = 0, right = s.length() - 1, minLength = s.length();
        boolean found = false;
        
        while(j<s.length()){
            char endChar = s.charAt(j++);
            if(map.containsKey(endChar)){
                map.put(endChar, map.get(endChar) - 1);
                if(map.get(endChar) == 0 ) count -= 1;
            }
            if(count > 0) continue;
            
            while(count == 0){
                char startChar = s.charAt(i++);
                if(map.containsKey(startChar)){
                    map.put(startChar, map.get(startChar) + 1);
                    if(map.get(startChar) > 0 ) count += 1;
            }       
            }
            if((j - i)< minLength){
                left = i;
                right = j;
                minLength = j-i;
                found = true;
            }
 
        }
        return !found ? "" : s.substring(left - 1, right);
    }
}
