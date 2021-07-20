/// Brute force 

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0 ; i <= nums.length-k; i++){
            int maxi = Integer.MIN_VALUE;
            int end = i;
            while(end < (i+k)){
                maxi = Math.max(nums[end], maxi);
                end++;
            }
            ans.add(maxi);
            
        }
        int result[] = new int[ans.size()];
        for (int i = 0 ; i < ans.size(); i++){
            result[i] = ans.get(i);
        }
        return result;
    }
}





/* TC O(M+N) SC O2((M+N))*/

class Solution {
    public String minWindow(String s, String t) {
        // map test string 
        //if (s.length() == 0 || s == null) return ""; 
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0 ; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) +1);
        }
        System.out.println(map);
        // map window map 
         Map<Character, Integer> winMap = new HashMap<>();
        
        int l = 0; 
        int r = 0 ; 
        
        int formed = 0 ; 
        int required = t.length();
        int[] ans = new int[]{-1, 0, 0}; // size, left, right
        while(r < s.length()){
            // add the chacters to the window map, if the char is present in the test map and the values are same, inc the formed variable
            char ch = s.charAt(r);
            winMap.put(ch, winMap.getOrDefault(ch, 0) +1);
            if (map.containsKey(ch) && winMap.get(ch).intValue() <= map.get(ch).intValue()){
                formed += 1;
            }
            
            while( l <= r && formed == required){
                // now that we have the larger substring satisfying the constriant, see if the string can be shrunk and still holds true
                  char c = s.charAt(l);
                if(ans[0] == -1 || r-l+1 < ans[0] ){
                    // found a better solution
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }
              
                winMap.put(c, winMap.get(c) -1);
                  if (map.containsKey(c) && map.get(c).intValue() > winMap.get(c).intValue()){
                formed -= 1;
            }
                
                
                l += 1;
            }    
            
            
            r += 1;
        }
        
        
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1); 
    }
}




