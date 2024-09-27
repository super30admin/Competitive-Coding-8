//https://leetcode.com/problems/minimum-window-substring/
// Time Complexity :O(s*t)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

//Sliding window
// Your code here along with comments explaining your approach
class Solution {
    public String minWindow(String s, String t) {
        
        if(t==null || t.length() ==0 || t.length() > s.length()) return "";
        
        HashMap<Character , Integer> tMap = new HashMap<>();
        
        HashMap<Character , Integer> sMap = new HashMap<>();
        
        int start =0;
        int min = t.length();
        int count =0;
        String result ="";
        
        for(int i =0 ;i<t.length();i++)
        {
            tMap.put(t.charAt(i) , tMap.getOrDefault(t.charAt(i),0)+1);
        }
        
        for(int end =0 ;end<s.length();end++){
            
            char ch = s.charAt(end);
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);
            
            if(tMap.containsKey(ch) && sMap.getOrDefault(ch ,0) <= tMap.getOrDefault(ch ,0)) count++;
            
            while(start <=end && count == min){
                
                if(result.length() ==0 || end-start+1 < result.length()){
                    result = s.substring(start,end+1);
                }
                
                char sc = s.charAt(start);
               
                sMap.put(sc , sMap.get(sc)-1);
                
                if(sMap.get(sc) ==0) sMap.remove(sc);
                
                if(sMap.getOrDefault(sc,0) < tMap.getOrDefault(sc,0)) count--;
                
                start++;
            }
        }
        
        return result;
    }
}