// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(int i = 0; i<t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        }

        int left = 0, right = 0, count = 0, minLength = Integer.MAX_VALUE;
        String result = "";
        while(right < s.length()) {
            char cRight = s.charAt(right);

            if(tMap.containsKey(cRight)) {
                sMap.put(cRight, sMap.getOrDefault(cRight, 0)+1);
                if(tMap.get(cRight) >= sMap.get(cRight)) {
                    count++;
                }

                while(count == t.length() && left<=right) {
                    if((right - left + 1) < minLength) {
                        minLength = right - left +1;
                        result = s.substring(left, right+1);
                    }
                    char lChar = s.charAt(left);
                    if(sMap.containsKey(lChar)) {
                        sMap.put(lChar, sMap.get(lChar) -1);
                        if(tMap.get(lChar) > sMap.get(lChar)) {
                            count--;
                        }
                    }
                    left++;
                }
                right++;
            } else {
                right++;
            }
        }
        return result;
    }
}