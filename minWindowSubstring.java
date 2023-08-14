// Time Complexity : O(s+t) //where s length of string s and t is len of string t
// Space Complexity : O(s+t) //where s length of string s and t is len of string t
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/*
 * We keep frequency map of t and traverse through s maintaining a window
 * itreatively checking if all the chars in t occur in the window tracking the have and need count.
 * when the count equals, move left pointer and shrink the window till have < need and continue to find the next minimum window.
 */
class Solution {
    public String minWindow(String s, String t) {
        // if(t.length()==0) return "";
        HashMap<Character, Integer> needMap = new HashMap();
        HashMap<Character, Integer> haveMap = new HashMap();
        int start = -1, end = -1, minWindow = s.length()+1;
        
        
        for( int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            needMap.put(ch, needMap.getOrDefault(ch,0)+1);
            haveMap.put(ch,0);
        }
        
        int need = needMap.size(), have = 0;
        for(int i = 0, j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            // if the char is from t
            if(haveMap.containsKey(ch)) {
                haveMap.put(ch, haveMap.get(ch)+1);
                if(haveMap.get(ch).equals(needMap.get(ch))) have++;
            }
            //  //now check if all the chars in t are present in our substring, and keep removing extra characters until the have lessens.
            while(have == need){
            
                //keep track of the indices
                 if(j-i+1 < minWindow){
                    minWindow = j-i+1;
                    start = i;
                    end = j;
                }
                ch = s.charAt(i);
                if(haveMap.containsKey(ch)) {
                    haveMap.put(ch, haveMap.get(ch)-1);
                    if(haveMap.get(ch) < needMap.get(ch)) have--;
                } 
                i++;
            }
        }
        
        return start==-1?"":s.substring(start,end+1);
    }
}