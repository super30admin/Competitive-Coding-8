//Time O(n)
//Space O(1)
//Leetcode: yes
//Issue seen : none
class Solution {
public:
    string minWindow(string s, string t) {
        unordered_map<char, int> mp;
        string ans = "";
        for(int i = 0; i < t.size(); i++){
            mp[t[i]]++;
        }

        int i=0;
        int j=0;
        int count=t.size();
        int win_start=i;
        int minLen = INT_MAX;
        while(j < s.size()){
          if(mp[s[j]] > 0){
            count --;
          }
          mp[s[j]]--;

          while(count==0) {
            if(minLen > j-i+1){
                minLen = j-i+1;
                win_start = i;
            }
            mp[s[i]]++;
            if(mp[s[i]] > 0){
                count++;
            }
            i++;
          }
          j++;

        }
        if(minLen != INT_MAX){
            ans = s.substr(win_start, minLen);
        }
        return ans;
    }
};
