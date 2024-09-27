//Time - O(len(s))
//Space - O(len(t))

class Solution {
public:
    string minWindow(string s, string t) {
        if(t == "" || t.size()>s.size()) return "";
        string ans = "";
        unordered_map<char,int> mp;
        unordered_map<char,int> ms;
        for(auto c:t){
            mp[c]++;
        }
        int i = 0,j = 0,cnt = 0;
        while(i<s.size() && j<s.size()){
            if(mp.find(s[i])!=mp.end()){
                mp[s[i]]--;
                if(mp[s[i]] >= 0)
                    cnt++;
            }
            while(cnt == t.size()){
                if(i-j+1<ans.size() || ans.size()==0){
                     ans = s.substr(j,i-j+1);
                }
                if(mp.find(s[j])!=mp.end() && mp[s[j]]<=0){
                   cout<<s[j]<<endl; 
                   mp[s[j]]++;
                }
                if(mp.find(s[j])!=mp.end() && mp[s[j]]>0){
                   cnt--; 
                }
                j++;
            }
            i++;
        }
        return ans;
    }
};