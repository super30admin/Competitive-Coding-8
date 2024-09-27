/** Given two strings s and t, return the minimum window in s which will contain all the characters in t. 
* If there is no such window in s that covers all characters in t, return the empty string ""
* TC O(S+T) represent the lengths of strings SS and T.
* O(∣S∣+∣T∣). |S| when the window size is equal to the entire string S. |T| when T has all unique characters.
*/
class Solution {
    public String minWindow(String s, String t) {
    if (s == null || s.length() == 0 ){
        return "";
    }
    if (t.length() > s.length()) {
        return "";
    }
    HashMap<Character, Integer> count = new HashMap<>();
    for(int i = 0; i < t.length(); i++) {
        char c = t.charAt(i);
        count.put(c, count.getOrDefault(c, 0) + 1);
    }
    int end = 0, beg = 0;
    int match = 0;
    int len = Integer.MAX_VALUE;
    int start = 0;
    while (end < s.length()) {
        char sChar = s.charAt(end);
        if (count.containsKey(sChar)) {
            count.put(sChar, count.get(sChar) - 1);
            if(count.get(sChar) == 0) {
                match++; 
            } 
        }
        while (match == count.size()) {
            if(end - beg < len) {
                len = end-beg+1;
                start = beg;
            } 
            char remove = s.charAt(beg);
            if(count.containsKey(remove)){
                count.put(remove, count.get(remove) + 1); 
                if(count.get(remove) > 0) {
                    match--;
                }
            }
            beg++;
        }
        end++;
    }
 
    return  len == Integer.MAX_VALUE? "" : s.substring(start, start + len);
    }
}
