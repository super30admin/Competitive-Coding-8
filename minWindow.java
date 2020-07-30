// Time Complexity : O(m+n) m and n lengths are lengths of two strings
// Space Complexity :O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character,Integer> req = new HashMap<>();
        for(int i=0;i<t.length();i++){
            req.put(t.charAt(i),req.getOrDefault(t.charAt(i),0)+1);
        }
        
        int formed = 0;
        int l=0;
        int r=0;
        
        int finalLeft=0;
        int finalRight=0;
        int res = -1;
        Map<Character,Integer> currWin = new HashMap<>();
        int required = req.size();
        while(l<s.length() && r<s.length() ){
            char c = s.charAt(r);
            
                currWin.put(c,currWin.getOrDefault(c,0)+1);
                if(req.containsKey(c) && req.get(c).intValue()==currWin.get(c).intValue())
                    formed++;
            
            while(formed == required && l<=r )
            {
                char outgoingChar = s.charAt(l);
                    
                if(res==-1 || (r-l+1)<res)
                {
                    finalLeft=l;
                    finalRight=r;
                    res = r-l+1;
                }
                
                
                
                currWin.put(outgoingChar,currWin.get(outgoingChar)-1);
                if(req.containsKey(outgoingChar) && req.get(outgoingChar).intValue()>currWin.get(outgoingChar).intValue())
                    formed--;
                
                l++;
            }
            
            r++;
            
        }
        
        return res==-1?"":s.substring(finalLeft,finalRight+1);
    }
}