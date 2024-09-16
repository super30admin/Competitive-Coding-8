//Time Complexity- O(s.length+t.length)
//Space Complexity- O(s.length+t.length)

class Solution {
public:
    string minWindow(string s, string t) {
        
        if(s.size()<t.size()){
            return "";
        }
        unordered_map<char,int> mpt;
        unordered_map<char,int> mps;
        for(char ch:t){
            mpt[ch]++;
        }
        
        int start=0 , start_index=-1 , ans=INT_MAX , count=0;
        
        for(int i=0;i<s.size();i++){
            mps[s[i]]++;
            
            if(mpt[s[i]]!=0 && mps[s[i]]<=mpt[s[i]]){
                count++;
            }
            
            if(count==t.size()){
                
                while(mps[s[start]]>mpt[s[start]] || mpt[s[start]]==0){
                    if(mps[s[start]]>mpt[s[start]]){
                        mps[s[start]]--;
                    }
                    start++;
                }
                int window_len=i-start+1;
                if(ans>window_len){
                    ans=window_len;
                    start_index=start;
                }
            }
        }
        if(start_index==-1){
            return "";
        }
        return s.substr(start_index,ans);
    }
};