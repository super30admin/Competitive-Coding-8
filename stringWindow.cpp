// Time Complexity :O(n) where n is the length of the string s 
// Space Complexity : O(1)   
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    unordered_map<char,int> hMap;
    string ans = "";
public:
    string minWindow(string s, string t) {
        if(t.length() > s.length()) return ans;
        for(auto c :t){
            hMap[c]++;
        }
        int slow = 0;
        int fast = 0;
        while(fast < s.length()){
            if(hMap.count(s[fast])){
                hMap[s[fast]]--;
                while(slow <= fast && checkValidity()){
                    if(hMap.count(s[slow])){
                        hMap[s[slow]]++;
                    }
                    if(ans.length() > 0 && ans.length() < fast-slow + 1 ) {}
                    else ans=s.substr(slow,fast-slow + 1 );
                    slow++;
                }
            }
            fast++;
        }
        return ans;
    }
    bool checkValidity(){
        for(auto pair : hMap){
            if(pair.second > 0) return false;
        }
        return true;
    }
};