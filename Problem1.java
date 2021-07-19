
// Time - O(|S| + |T|)
// Space  - O(|S| + |T|)


class Solution {
    public String minWindow(String s, String t) {

        if(s == null || s.length() == 0) return "";

        if(t.length () > s.length()) return "";

        HashMap<Character, Integer> map = new HashMap<Character,Integer>();

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        int start = 0;
        int len = Integer.MAX_VALUE;
        int beg = 0;
        int end = 0;
        int match = 0;

        while(end < s.length()) {

            char sChar = s.charAt(end);
            if(map.containsKey(sChar)) {
                map.put(sChar, map.get(sChar) - 1); // decrement the searched character
                if(map.get(sChar) == 0) {
                    match++; // increment the match
                }
            }

            while(match == map.size()) {

                if(end - beg < len) { // calculate the min length
                    len = end - beg + 1;
                    start = beg; // store the start point of the substring to display
                }

                char remove = s.charAt(beg);
                if(map.containsKey(remove)) {
                    map.put(remove,map.get(remove) + 1); // increment the count when char found
                    if(map.get(remove) > 0) { // if the count is more then 0 decrement the match
                        match--;
                    }
                }
                beg++;
            }

            end++;
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len); // return the substring



    }
}