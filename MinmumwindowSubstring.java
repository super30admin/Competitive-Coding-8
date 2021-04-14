class Solution {
    public String minWindow(String s, String t) {
        //edge case
        if(s.length() == 0 || t.length() == 0){
          return "";
        }
        
        //Storing characters and its count in a map
        Map<Character, Integer> dictT = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            dictT.put(t.charAt(i), dictT.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        int required = dictT.size();
        int formed = 0;
        
        int left = 0;
        int right = 0;
        
        Map<Character, Integer> window = new HashMap<>();
        int[] ans = {-1, 0, 0};
        
        while(right < s.length()){
            // storing the current character and its corresponding count into window map
            char c = s.charAt(right);
            int count = window.getOrDefault(c, 0);
            window.put(c, count+1);
            
            // check if the current charcater is part of DictT
            //if so check if the count matches in both dictT and window
            if(dictT.containsKey(c) && dictT.get(c).intValue() == window.get(c).intValue()){
                formed++;
            }
            
            // try to contarct the window and check if is still valid
            while(left <= right && formed == required){
                c = s.charAt(left);
                
                // save smallest window till now
                if(ans[0] == -1 || right-left+1 < ans[0]){
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                
                //remove the element at left pointer from window
                //and check if that window is still valid or not
                //if not valid then reduce formed
                window.put(c, window.get(c) - 1);
                if(dictT.containsKey(c) && dictT.get(c).intValue() > window.get(c).intValue()){
                    formed--;
                }
                left++;
            }
            right++;
        }
        
        return ans[0]== -1 ? "" : s.substring(ans[1], ans[2]+1);
    }
  }
  //Time Complexity: O(S+T)
//   Space Complexity: O(S+T)