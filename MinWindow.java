import java.util.HashMap;

public class MinWindow {
    // TC O(S+T) Where S and T represent the length of Strings S and T
    // SC O(1)

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
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
                if (count.get(sChar) == 0) {
                    match++;
                }
            }
            while (match == count.size()) {
                if (end - beg < len) {
                    len = end - beg + 1;

                    start = beg;
                }

                char remove = s.charAt(beg);
                if (count.containsKey(remove)) {
                    count.put(remove, count.get(remove) + 1);
                    if (count.get(remove) > 0) {
                        match--;
                    }
                }
                beg++;
            }
            end++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
