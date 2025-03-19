import java.util.HashMap;
import java.util.Map;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        int l = 0, r = 0, formed = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (r < s.length()) {
            char c = s.charAt(r);

            if (tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                if (sMap.get(c).intValue() == tMap.get(c).intValue()) {
                    formed++;
                }
            }

            while (formed == tMap.size()) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    start = l;
                }

                char leftChar = s.charAt(l);
                if (tMap.containsKey(leftChar)) {
                    sMap.put(leftChar, sMap.get(leftChar) - 1);
                    if (sMap.get(leftChar).intValue() < tMap.get(leftChar).intValue()) {
                        formed--;
                    }
                }
                l++;
            }
            r++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
