class Solution {
public:
    string minWindow(string s, string t) {
     unordered_map<int,int>mp;
        int mnL=INT_MAX;
        int start;
        
        for(int i=0;i<t.length();i++){
            mp[t[i]]++;
        }
        int count =mp.size();
        int i=0;
        int j=0;
        
        while(j<s.length()){
            mp[s[j]]--;
            
            if(mp[s[j]]==0){
                count--;
            }
            
            if(count==0){
                
                while(count==0){
                    //  possible answers
                    if(mnL > j-i+1){
                        mnL=min(mnL,j-i+1);
                        start=i;                           // Starting index of the window of ans
                    }
                    
                    mp[s[i]]++;                           //we are again checking in map even if mp[s[i]]==0
                                                          //it is telling that we will discard that extra char taken when the min length string is founded;
                    if(mp[s[i]] > 0){
                        count++;
                    }
                    i++;
                }
            }
            j++;
            
        }
        string str="";
        if(mnL!=INT_MAX)
            return str+=s.substr(start,mnL);
        else
            return str;
    }
};
