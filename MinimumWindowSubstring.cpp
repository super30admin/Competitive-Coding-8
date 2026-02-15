class Solution {
public:
    string minWindow(string s, string t) {
        unordered_map<char, int> patMap, stringMap;
        for (char ch: t) {
            patMap[ch]++;
        }

        int start = 0;
        int right = 0;
        int patSize=0; // represent the number of char of pattern that i have found in string s.
        vector<int> answer = {-1, 0, 0}; // {length, startIndex, endIndex};
        int reqSize=patMap.size();
        while(start < s.length() && right < s.length()) {
            char ch = s[right];
            stringMap[ch]++;
            if (stringMap[ch] == patMap[ch]) {
                patSize++;
            }
            while (patSize == reqSize) {
                if (answer[0] == -1 || right-start+1 < answer[0]) {
                    answer[0] = right-start+1;
                    answer[1] = start;
                    answer[2] = right;
                }
                stringMap[s[start]]--;
                if (stringMap[s[start]] < patMap[s[start]]) {
                    patSize--;
                }
                start++;
            }
            right++;
        }

        return answer[0] == -1 ? "" : s.substr(answer[1], answer[0]);
    }
};
