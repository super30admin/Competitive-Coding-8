
// Time Complexity : O(|S|+|T|);
// Space Complexity : O(|S|+|T|)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(tLen > sLen) return "";
        if(t.equals(s)) return t;
        HashMap<Character,Integer> currMap = new HashMap<>(tLen);
        HashMap<Character,Integer> tMap = new HashMap<>(tLen);
        for(int i = 0 ; i < t.length() ; i++){
            char c = t.charAt(i);
            tMap.put(c,tMap.getOrDefault(c,0)+1);
            currMap.put(c,0);
        }
        int l = 0;
        int have = 0;
        int want = tMap.size();
        int lMin = -1;
        int rMin = -1;
        int len = Integer.MAX_VALUE;
        for(int r = 0 ; r < sLen ; r++){
            char in = s.charAt(r);
            if(currMap.containsKey(in)){
                int val = currMap.get(in);
                val++;
                currMap.put(in,val);
                if(val == tMap.get(in)) have++;
                while(have == want){
                    if(r-l+1 < len){
                        len = r-l+1;
                        rMin = r;
                        lMin = l;
                    }
                    char out = s.charAt(l);
                    if(currMap.containsKey(out)){
                        int outVal = currMap.get(out);
                        outVal--;
                        currMap.put(out,outVal);
                        if(outVal < tMap.get(out)) have--;
                    }
                    l++;
                }
            }
        }
        if(len == Integer.MAX_VALUE) return "";
        //System.out.println(len);
        return s.substring(lMin,rMin+1);
        
    }
}
