class minimumWindowSubString {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        int slow = 0, fast = Integer.MAX_VALUE;
        int match = map.size();
        for (int left = 0, right = 0; right < s.length(); right++) {
            char cRight = s.charAt(right);
            if (map.containsKey(cRight)) {
                map.put(cRight, map.get(cRight) - 1);
                if (map.get(cRight) == 0) {
                    match -= 1;
                }
            }

            while (match <= 0) {
                char cLeft = s.charAt(left);
                if (map.containsKey(cLeft)) {
                    map.put(cLeft, map.get(cLeft) + 1);
                    if (map.get(cLeft) >= 1) {
                        match += 1;
                    }
                }
                if (right - left + 1 < fast) {
                    slow = left;
                    fast = right - left + 1;
                }
                left++;
            }
        }
        return fast == Integer.MAX_VALUE ? "" : s.substring(slow, slow + fast);
    }
}

//time complexity O(m + n) where m is length of s and n is lenght of t
//space complexity O(1)