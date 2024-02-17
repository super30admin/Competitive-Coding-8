// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int left = 0, right = 0, ans = Integer.MAX_VALUE, match = map.size();
        int fl=0,fr=0;
        while(right < s.length()){
            char rch = s.charAt(right);
            if(map.containsKey(rch)){
                int cnt = map.get(rch)-1;
                if(cnt == 0)
                    match--;
                map.put(rch,cnt);
                if(match == 0){
                    while(match == 0){
                    if(right - left + 1 < ans){
                        ans = right - left+1;
                        fl = left;
                        fr = right;
                    }
                    char lch = s.charAt(left);
                    if(map.containsKey(lch)){
                    
                    int count = map.get(lch)+1;
                    map.put(lch,count);
                    if(count == 1)
                        match++;
                    
                    }
                    left++;
                    }
                }
                
            }
            right++;
            
        }
        if(ans == Integer.MAX_VALUE)
                return "";
        return s.substring(fl,fr+1);
    }
}