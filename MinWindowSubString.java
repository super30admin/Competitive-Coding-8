class Solution {
    public String minWindow(String s, String t) {
        return findSubString(s, t);
    }

    //TC: O(n) [n: length of s]
    //Sc: O(1)
    private String findSubString(String str, String pat) {
        int len1 = str.length();
        int len2 = pat.length();

        if (len1 < len2) {
            return "";
        }

        int hash_pat[] = new int[256];
        int hash_str[] = new int[256];

        for (int i = 0; i < len2; i++) {
            char c = pat.charAt(i);
            hash_pat[c] += 1;
        }

        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;

        int count = 0;

        for (int j = 0; j < len1; j++) {
            char cStr = str.charAt(j);
            hash_str[cStr] += 1;

            if (hash_str[cStr] <= hash_pat[cStr]) {
                count++;
            }

            if (count == len2) {
                while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]
                        || hash_pat[str.charAt(start)] == 0) {

                    if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]) {
                        hash_str[str.charAt(start)]--;
                    }
                    start++;
                }

                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        if (start_index == -1) {
            return "";
        }

        return str.substring(start_index,
                start_index + min_len);
    }

}