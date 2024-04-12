// t-c: n
//s-c: 1
class Solution {
public:
    string minWindow(string s, string t) {
        unordered_map<char,int> freq;
        for(char ch: t){
            freq[ch]++;
        }
        int i = 0, j = 0, n = freq.size();
        int minimum = INT_MAX, len = 0, startIdx;
        while(j < s.size()){
            if(freq.find(s[j]) != freq.end()){
                    freq[s[j]]--;
                    if(freq[s[j]] == 0){
                        len++;
                }
            }
            while(len == n){
                if(minimum > (j-i)){
                    startIdx = i;
                    minimum = j-i;
                }
                if(freq.find(s[i]) != freq.end()){
                    freq[s[i]]++;
                    if(freq[s[i]] > 0){
                        len--;
                    }
                }
                i++;
            }
            j++;
        }
        if(minimum == INT_MAX)
            return "";
        return s.substr(startIdx,minimum +1);
    }
};
