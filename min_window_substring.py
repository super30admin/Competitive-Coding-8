# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I use two pointer untill I have right amout of occurrences of all the letters then I increments the left pointer until I reach the right
# pointer and reduce the result length until I still have all the target counts. I result the string within the minimum range

class Solution {
public:
    string minWindow(string s, string t) {
        map<char, int> counter;
        map<char, int> target;
        int length_s = s.size();
        int length_t = t.size();
        for (int i=0; i<length_t; i++) {
            target[t[i]]++;
        }
        
        int left = 0;
        int right = 0;
        int matches = 0;
            
        int target_length = target.size();
        int minimum = std::numeric_limits<int>::max();
        int start = -1;
        int end = -1;
        
        while (right < length_s) {
            char current_char = s[right];
            if (target[current_char] >= 0) {
                counter[current_char]++;
                if (counter[current_char] == target[current_char]) {
                    matches++;
                    if (matches == target_length) {
                        int length = right - left + 1;
                        if (length < minimum) {
                            minimum = length;
                            start = left;
                            end = right;
                        }
                        char leftChar = s[left];
                        counter[leftChar]--;
                        left++;
                        while (counter[leftChar] >= target[leftChar]) {
                            minimum = minimum - 1;
                            start = left;
                            leftChar = s[left];
                            counter[leftChar]--;
                            left++;
                        }
                        matches -= 1;
                    }
                }
            }
            right++;
        }
        if (start < 0) {
            return "";
        }
        return s.substr(start, minimum);
    }
};
