//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character,Integer> map1 = new HashMap<>();
        
        for(int i = 0; i < t.length(); i ++){
            
            map1.put(t.charAt(i),map1.getOrDefault(t.charAt(i),0)+1);
        }
        
        int required = map1.size();
        
        int formed = 0;
        
        int left = 0;
        int r = 0;
        
        HashMap<Character,Integer> map2 = new HashMap<>();
        
        int[] ans = {-1,0,0};
        
        while(r < s.length()){
            
            char c = s.charAt(r);
            
            map2.put(c,map2.getOrDefault(c,0)+1);
            
            if(map1.containsKey(c) && map2.get(c) == map1.get(c)){
                
                formed ++;
            }
            
            while(left <= r && formed == required){
                
                c = s.charAt(left);
                
                if(ans[0] == -1 || r - left + 1 < ans[0]){
                ans[0] = r - left + 1;
                  ans[1] = left;
                  ans[2] = r;
                    
                }
                map2.put(c, map2.get(c) - 1);
                 if(map1.containsKey(c) && map2.get(c) < map1.get(c)){
                
                formed --;
            }
                
                left ++;
                
            }
            
            r ++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}