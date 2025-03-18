// https://leetcode.com/problems/minimum-window-substring/
// Time Complexity: O(s+t)
// Space Complexity: O(1)

class Solution {
    public:
        string minWindow(string s, string t) {
            int n = s.length();
            int m = t.length();
            if(n<m) return "";
            unordered_map<char,int> mp;
            for(auto i:t){
                mp[i]++;
            }
            int cnt=0; int l=0; int r=0; int idx=-1; int len = INT_MAX;
            while(r<n){
                if(mp[s[r]] > 0){
                    cnt++;
                }
                mp[s[r]]--;
                while(l<=r && cnt==m){
                    if(r-l+1 < len){
                        len = r-l+1;
                        idx = l;
                    }
                    mp[s[l]]++;
                    if(mp[s[l]] > 0) cnt--;
                    l++;
                }
                r++;
            }
            return idx == -1 ? "" : s.substr(idx, len);
        }
    };