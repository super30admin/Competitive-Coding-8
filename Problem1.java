import java.util.HashMap;

public class Problem1 {
    //Sliding window
    // TC : O (m)
    // SC : O (n)
    public String minWindow(String s, String t) {
        if (s == null || t == null) return s;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int match = 0;
        int sLength = Integer.MAX_VALUE;
        String result = "";

        while (right < s.length()) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                int count = map.get(c);
                count--;
                if (count == 0) {
                    match++;
                }
                map.put(c, count);
            }

            while (match == map.size()) {
                c = s.charAt(left);

                if (right - left + 1 < sLength) {
                    sLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                if (map.containsKey(c)) {
                    int count = map.get(c);
                    count++;
                    if (count == 1) {
                        match--;
                    }
                    map.put(c, count);
                }

                left++;
            }
            right++;
        }

        return result;

    }
}
