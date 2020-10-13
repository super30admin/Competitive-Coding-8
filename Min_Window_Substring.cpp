// Time Complexity : O(m) 
// Space Complexity : O(m) for the hashmaps
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning



class Solution {
public:
    string minWindow(string s, string t) {
        //edge case
        if(s.length()==0 || t.length()==0) return "";
        
        //logic: sliding window
        unordered_map <char, int> char_map;
        for(int i=0;i<t.length(); i++) ++char_map[t[i]];
        
        unordered_map <char, int> sliding_window_count;
        
        int match=0;
        int window_size=-1, right=0,left=0;
        int slow=0; int fast=0;
        
        for(fast=0;fast<=s.length();fast++){
            //incoming character
            char in = s[fast];
            if(char_map.find(in)!= char_map.end()){
          
                sliding_window_count[in] ++;
               if(sliding_window_count[in]==char_map[in]) match++;
      
             }
           
            //outgoing character
            while(match==char_map.size() && slow<=fast){ //all elements found
                //update the window
                if(window_size==-1 || window_size>(fast-slow+1)){
                    window_size=(fast-slow+1);
                    left=slow; right=fast;
                }
           
                char out = s[slow];
                if(char_map.find(out)!= char_map.end()){
               
                    sliding_window_count[out] --;
                    if(sliding_window_count[out]<char_map[out]) match--;
                }
                slow++;
            }
        }
        
        return (window_size==-1? "":s.substr(left,window_size));
    }
};
