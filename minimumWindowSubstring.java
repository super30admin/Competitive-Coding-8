// Time Complexity :O(m+n) m =s.length n=t.length
// Space Complexity :O(1) - since max can be O(26) of t.length
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<t.length();i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        int left = 0;
        int match = 0;
        
        int currLength= Integer.MAX_VALUE;
        
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            //incoming characters
            if(map.containsKey(c)){
                int count = map.get(c);
                count--;
                if(count==0){
                    match++;
                }
                map.put(c, count);
            }
            
            //store substrings
            while(match==map.size()){
                if(right-left+1<currLength){
                    result = s.substring(left, right+1);
                    currLength = right-left+1;
                }
                
                //outgoing characters
                c = s.charAt(left);
                if(map.containsKey(c)){
                    int count = map.get(c);
                    count++;
                    if(count==1){
                        match--;
                    }
                    map.put(c, count);
                }
                left++;
            }
        }
        return result;
    }
}