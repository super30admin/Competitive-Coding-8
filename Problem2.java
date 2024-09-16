// Time Complexity : O(n)
// Space Complexity : O(n+m)

//This code is not getting submitted, can you please check it and tell whats the mistake?

class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0)
            return "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        
        int[] res = new int[]{-1, 0, 0};
        int required = 0, formed = 0;
        
        res[0] = -1;
        
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        required = map.size();
        
        int l=0 ,r=0;
        
        while(r<s.length()){
            char c = s.charAt(r);
            
            window.put(c, window.getOrDefault(c, 0)+1);
            
            if(map.containsKey(c) && window.get(c) == map.get(c))
                formed++;
                
            while(l<=r && formed == required){
                if(res[0] == -1 || res[0]> r-l+1){
                    res[0] = r-l+1;
                    res[1] = l;
                    res[2] = r;
                }
                
                c = s.charAt(l);
                window.put(c, window.get(c)-1);
                    
                if(map.containsKey(c) && window.get(c) < map.get(c))
                    formed--;
                l++;
            }
            r++;
        }          
    
        return res[0] == -1 ? "" : s.substring(res[1], res[2]+1);
    }
}