/*

Passed All Test Cases 

Time -> O(S + T), where S in # of chars in s and T is # of chars in t 
Space-> O(S + T), where S in # of chars in s and T is # of chars in t 



*/


class Solution {
    public String minWindow(String s, String t) {
        //edge case
        if(s.length() < t.length()) return "" ; 
        
        //storing the char freq using hashmap 
        HashMap<Character, Integer> mapT = new HashMap<>() ; 
        
        for(int i = 0 ; i < t.length() ; i++) {
            char add = t.charAt(i) ; 
            mapT.put(add , mapT.getOrDefault(add, 0) + 1) ; 
        }
        
        //to store the freq of the window
        HashMap<Character, Integer> mapS = new HashMap<>() ; 
        
        //using two pointers
        int start = 0 , end = 0 ;
        
        int sizeNeeded = mapT.size() ; 
        
        int sizeFormed = 0 ; 
        
        //to store the ans
        int [] ans = {-1, 0, 0} ; 
        
        while(end < s.length()) {
            
            //char at end
           char check = s.charAt(end) ; 
            
            //adding check freq to mapS
            mapS.put(check, mapS.getOrDefault(check, 0) + 1) ; 
            
            if(mapT.containsKey(check) && mapS.get(check).intValue() == mapT.get(check).intValue())
                sizeFormed++ ; 
            
            while(start <= end && sizeFormed == sizeNeeded) {
                
                //updating the ans for min window
                if(ans[0] == -1 || (end - start + 1) < ans[0]) {
                    ans[0] = end - start + 1 ;  
                    ans[1] = start ;  
                    ans[2] = end ;  ; 
                }
                
                char toRemove = s.charAt(start) ; 
                
                
                    mapS.put(toRemove, mapS.getOrDefault(toRemove, 0) - 1) ; 
                
                if(mapT.containsKey(toRemove) && mapS.get(toRemove) < mapT.get(toRemove))
                   sizeFormed-- ; 
                
                start++ ; 
            }
            
            end++ ; 
            
            
        }
        
            return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1) ; 
    }
}