import java.util.HashMap;
import java.util.Objects;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) { //O(m+n) T.C, O(m) S.C
        int sl = s.length();
        int tl = t.length();

        //optimizations
        if(tl > sl) return "";
        if(sl == tl) {
            if(Objects.equals(s, t)) return t;
        }

        HashMap<Character, Integer> map = new HashMap<>(); //O(m) S.C, frequency map of t
        for(int i=0; i<tl; i++) { //O(m) T.C where m is length of t
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0; //pointers
        int count = 0;
        int start = 0;

        while (right < sl) { //O(n) T.C where n is length of s, while fast pointer right is less than length
            char rChar = s.charAt(right);

            // If the character is part of t, decrease its count in the map
            if (map.containsKey(rChar)) { //if current char at right is in the map
                map.put(rChar, map.get(rChar) - 1); //reduce its frequency
                if (map.get(rChar) == 0) count++; //if its frequency becomes 0, increase the count of matched chars
            }

            // When all characters are matched
            while (count == map.size()) { //if the count of matches chars is the same as size of map
                if (right - left + 1 < minLen) { //check if the current substring range is lesser than previous
                    minLen = right - left + 1; //if yes, make this new range as the minimum length
                    start = left; //and move the start to its left pointer
                }

                char lChar = s.charAt(left);

                // Move the left pointer to minimize the window
                if (map.containsKey(lChar)) { //after finding all chars of t in the current range,
                    // start moving left to reduce the substring space
                    map.put(lChar, map.get(lChar) + 1); //if left char is in the map, increase its frequency
                    if (map.get(lChar) > 0) count--; //if frequency is positive, that means we lost a matched char
                }
                left++; //if map doesn't contain left, that means we continue moving left
            } //loop breaks when count is no longer matching with map size
            right++; //increment right until end of s
        }

        return minLen == //If the min length of substring hasn't changed at all, then there is no match
                Integer.MAX_VALUE ? "" : s.substring(start, start + minLen); //else, return substring from start to len
    }

    public static void main(String[] args) {
        String s = "WonderkidNithinisagreatguyevertobehere";
        String t = "Ngirtehaitnasiyug";

        System.out.println("The minimum substring in " + s + " where all the letters in " + t +
                " are present is: " + minWindow(s, t));
    }
}