package minimumWindowSubstring;

//Time Complexity (TC)
//O(N + M), where
//N is the length of s
//M is the length of t
//SC -> O(M)

//We first build a frequency array hash for characters in t, then use two pointers (l and r) to expand and contract the window dynamically.
//As we expand (r), we decrement hash[s.charAt(r)] and increase count when a needed character is found.
//Once all characters are matched (count == t.length()), we attempt to shrink the window (l++) while updating the minimum window length, finally returning the smallest valid substring.

class Approach1 {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> freqMap = new HashMap();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int uniqueCharCount = freqMap.size();
        int startIndex = -1;
        int windowStart = 0;
        int windowEnd = 0;
        int minLen = Integer.MAX_VALUE;

        int N = s.length();

        while (windowEnd < N) {
            // expansion
            char ch = s.charAt(windowEnd);

            if (freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) - 1);

                if(freqMap.get(ch) == 0) {
                    uniqueCharCount--;
                }
            }

            // shrinking phase
            while(uniqueCharCount == 0) {
                // find len
                int len = windowEnd - windowStart + 1;

                if(len < minLen) {
                    minLen = len;
                    startIndex = windowStart;
                }

                ch = s.charAt(windowStart);

                if(freqMap.containsKey(ch)) {
                    freqMap.put(ch, freqMap.get(ch) + 1);

                    if(freqMap.get(ch) > 0) {
                        uniqueCharCount++;
                    }
                }

                windowStart++;
            }

            windowEnd++;
        }

        if(startIndex == -1) {
            return "";
        }

        return s.substring(startIndex, startIndex + minLen);
    }
}