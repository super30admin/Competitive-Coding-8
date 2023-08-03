class Solution {
public:
    string minWindow(string s, string t) {
        
        if(s == "" || t == "") return ""; 

        map<char,int> tmp; 
        map<char,int> mp; 

        int r = 0; 
        int l = 0; 
        vector<int> ans = {INT_MAX,0,0}; // length, left, right

        for(int i = 0; i < t.size(); i++) {
            tmp[t[i]]++; 
        }

        int required = tmp.size(); 
        int formed = 0; 

        while(r < s.size()) {
            mp[s[r]]++; 
            if(tmp[s[r]] != 0 && mp[s[r]] == tmp[s[r]]) formed++; 
                
            while(l <= r && formed == required) {
                char c = s[l];
                //get current length of window, if existing one is too big
                if(ans[0] > (r-l+1)) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r; 
                }

                mp[c]--;
                if(tmp[c] != 0 && mp[c] < tmp[c]) formed--; 
                l++; 
            }

            r++;     
        }

        return ans[0] == INT_MAX ? "" : s.substr(ans[1], ans[2] - ans[1] + 1); 

    }
};