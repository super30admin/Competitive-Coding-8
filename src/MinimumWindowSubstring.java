// Time Complexity:  O(max(m, n))
// Space Complexity: O(n)
//
// where m is length of s, and n is length of t

class Solution {
    public String minWindow(String s, String t) {

        if(s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        Map<Character, Integer> tCount = new HashMap<>();

        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            tCount.put(ch, tCount.getOrDefault(ch, 0) + 1);
        }

        int i=0;
        int j=0;
        int remaining = t.length();
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;

        while(j<s.length()) {
            
            char ch = s.charAt(j);
            
            if(tCount.containsKey(ch)) {                           // incoming character is in string "t"
                int count = tCount.get(ch);
                if(count > 0) {
                    remaining--;
                }
                tCount.put(ch, count-1);
            }
            j++;

            while(remaining == 0) {                               // substring covering all characters 
                if(minLength > j-i) {                             // shorter substring
                    minLength = j-i;
                    minStart = i;
                }

                char chI = s.charAt(i);

                if(tCount.containsKey(chI)) {                     // if outgoing character was in string "t"
                    int count = tCount.get(chI);
                    if(count == 0) {
                        remaining++;
                    }
                    tCount.put(chI, count+1);
                }
                i++;
            }

        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLength);
    }
}
