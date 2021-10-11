// Time: O(m+n) where m is number of character in s and n in string t
// as we keep traversing each element without repeating any traversal
// Space: O(n) n is number of character in t
// Idea here is to use sliding window to identify the first range where all the required characters are present.
// To keep the count we have used map on t string characters. This will allow us to make comparison in O(1) time.
// once one range is achieved we can reduce the window by eleminating from left and keep check if the count 
// is still same as number of characters in t, then we can update minLength and corresponding left
// when right reaches end of s string we can stop and return the substring of minLeft
// and upto minLength to get smalles window substring
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        String res= "";
        int m = s.length(); int n = t.length();
        for(int i=0; i< n; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) +1);
        }
        int left = 0; int count = 0;
        int minLeft = 0; int minLen = m+1;
        for(int right=0; right<m; right++){
            char c = s.charAt(right);
            if(map.containsKey(c)) {
                map.put(s.charAt(right), map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right))>=0) {
                    count++;
                }
                
                while(count==n){
                    if(right-left+1<minLen) {
                        minLeft = left;
                        minLen = right-left+1;
                    }
                    if(map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left))+1);
                        if(map.get(s.charAt(left))>0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if(minLen>m) {
            return res;
        }
        res = s.substring(minLeft, minLeft+minLen);
        return res;
    }
}