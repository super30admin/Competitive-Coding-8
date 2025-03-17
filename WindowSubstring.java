
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Sliding window
 */

class Solution {
    public String minWindow(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (sl == 0 || tl == 0)
            return "";

        HashMap<Character, Integer> tmap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        int required = tmap.size();
        int formed=0;

        int left = 0;
        int right = 0;

        HashMap<Character, Integer> smap = new HashMap<>();
        int[] ans={-1,0,0};

        while (right < sl) {
            char c = s.charAt(right);
            smap.put(c,smap.getOrDefault(c,0)+1);
            if(tmap.containsKey(c) && tmap.get(c).intValue()==smap.get(c).intValue()){
                formed++;
            }

            while(left<=right && required==formed){
                if(ans[0]==-1 || right-left+1<ans[0]){
                    ans[0]=right-left+1;
                    ans[1]=left;
                    ans[2]=right;
                }

                char nc=s.charAt(left);
                smap.put(nc,smap.get(nc)-1);
                if(tmap.containsKey(nc) && smap.get(nc)<tmap.get(nc)){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
