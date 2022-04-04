// Time Complexity : o(256 * n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//sliding window approach, keep map of result  string and each step compare the two maps.
// Things can be optimised using formed int variable approach where increment formed int var if we find a
//character with same frequency as result string
class Solution {
    public String minWindow(String s, String t) {

        if(t.length() > s.length()) return "";

        String res = "";
        int len = Integer.MAX_VALUE;

        int[] mapT = new int[256];
        for(int i=0; i<t.length(); i++){
            mapT[t.charAt(i)-'\0'] +=1;
        }

       int[] mapS = new int[256];
       int start = 0;
       int end = 0;

        while(end <= s.length()){

            while(comapreMaps(mapT, mapS)){
                if(len > end - start){
                    res = s.substring(start, end);
                    len = end - start;
                }
                mapS[s.charAt(start)-'\0'] -= 1;
                start++;
            }
            if(end < s.length())
                mapS[s.charAt(end)-'\0'] +=1;
            end++;
        }
        return res;
    }

    public boolean comapreMaps(int[] mapT, int[] mapS){
        for(int i=0; i< 256; i++){
            if(mapT[i] != 0 && mapT[i] > mapS[i]) return false;
        }
        return true;
    }
}
