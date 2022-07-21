//Time : O(n)
//Space : O(1)

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int match = 0;
        int temp = Integer.MAX_VALUE;
        StringBuilder result = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < s.length()) {
            if (match == map.size()) {
                temp = Math.min(temp, j - i);
                if (temp == j - i) {
                    result.setLength(0);
                    for (int k = i; k < j; k++) {
                        result.append(s.charAt(k));
                    }
                }
            }

            if (i != j && match == map.size() || j == s.length()) {
                if (map.containsKey(s.charAt(i))) {
                    if (map.get(s.charAt(i)) == 0) {
                        match = match - 1;
                    }
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                }
                i++;
            } else {
                if (map.containsKey(s.charAt(j))) {
                    if (map.get(s.charAt(j)) == 1) {
                        match = match + 1;
                    }
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                }
                j++;
            }
        }
        return result.toString();
    }
}