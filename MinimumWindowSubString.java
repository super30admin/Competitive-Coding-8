// Time Complexity : O(S)+O(t)
// Space Complexity : o(t)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public String minWindow(String s, String t) {
     
        if(s == null || s.length() < t.length() || s.length() == 0)
        {
          return "";
        }  
        
        HashMap<Character,Integer> map=new HashMap<>();
        
        for(char c:t.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int left=0;
        int minLeft=0;
        int minLen=s.length()+1;
        int count=0;
        
        for(int right=0;right<s.length();right++)
        {
            if(map.containsKey(s.charAt(right)))
            {
                map.put(s.charAt(right),map.get(s.charAt(right))-1);
                
                if(map.get(s.charAt(right))>=0)
                    count++;
            }
            
            while(count==t.length())
            {
                if(right-left+1 <minLen)
                {
                    minLeft=left;
                    minLen=right-left+1;
                }
                
                if(map.containsKey(s.charAt(left)))
                 {
                       map.put(s.charAt(left),map.get(s.charAt(left))+1);
                    
                    if(map.get(s.charAt(left))>0)
                      count--;
                }
                
                left++;
            }
        }
        if(minLen>s.length())  
        {  
        return "";  
        }  
        return s.substring(minLeft,minLeft+minLen);
    }
}