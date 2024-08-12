class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";

        if (s.equals(t))
            return s;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        int match = 0;
        String result = "";
        int length = Integer.MAX_VALUE;
        for (int j = 0; j < s.length(); j++) {
            char in = s.charAt(j);
            if (map.containsKey(in)) {
                int count = map.get(in) - 1;
                map.put(in, count);
                if (count == 0)
                    match++;
            }

            if (match == map.size()) {
                while (match == map.size()) {
                    char out = s.charAt(i);
                    if (map.containsKey(out)) {
                        int count = map.get(out) + 1;
                        map.put(out, count);
                        if (count == 1)
                            match--;
                    }
                    if (length > j - i + 1) {
                        result = s.substring(i, j + 1);
                        length = result.length();
                    }
                    i++;
                }
            }

        }

        return result;
    }
}
