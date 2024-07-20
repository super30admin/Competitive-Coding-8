import java.util.HashMap;
import java.util.Map;

/***
 Using Sliding Window
 TC - O(S + T), SC - O(T)
 */
class MinWindowSubstr {
    public String minWindow(String s, String t) {
        //base case
        if(s == null || s.length() == 0 || t == null || t.length() ==0 || t.length() > s.length()) {
            return "";
        }

        //map to store the frequency of characters in the string t
        Map<Character, Integer> hm = new HashMap<>();
        for(char ch : t.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }

        int minLen = s.length()+1;
        int start=0;
        int match =0;
        int j =0;

        for(int i =0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(hm.containsKey(ch)) {
                //decrement the count
                int count = hm.get(ch) -1;
                hm.put(ch, count);
                if(count == 0) {
                    match++;
                }
            }

            //if all characters in map are found, then we found one possible solution
            while(match == hm.size()) {
                if(minLen >= i-j+1) {
                    minLen = i-j+1;
                    start =j;
                }

                char c = s.charAt(j);
                if(hm.containsKey(c)) {
                    if(hm.get(c) == 0)
                        match--; // decrement match
                    //increment its count
                    hm.put(c, hm.get(c)+1);
                }

                //move to next window using j
                j++;
            }
        }

        return minLen > s.length()? "" : s.substring(start, start+minLen);
    }
}