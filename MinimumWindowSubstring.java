//time complexity- O(m+n)
//space complexity- O(1)
import java.util.*;
public class MinimumWindowSubstring {
    static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m == 0 || n == 0 || m < n) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = 0;
        int match = 0;
        int tempI = 0;
        int tempJ = Integer.MAX_VALUE;
        while(j < m) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) match++;
            }

            while (match == map.size()) {
                if (tempJ - tempI > j - i) {
                    tempJ = j + 1;
                    tempI = i;
                }

                char leftChar = s.charAt(i);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) == 1) match--;
                }
                i++;
            }

            j++;
        }

        StringBuilder sol = new StringBuilder();
        if(tempJ != Integer.MAX_VALUE) {
            for(i = tempI; i < tempJ; i++) {
                sol.append(s.charAt(i));
            }
        }

        return sol.toString();
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window for \"" + t + "\" in \""+ s +"\" is: \""+ minWindow(s, t) + "\"");
    }
}
