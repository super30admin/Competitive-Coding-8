// Time Complexity :O(m+n) // The slow and fast pointer can go through the array two times O(m+2n)
// Space Complexity : O(2m) //2 Hashmaps
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//1. Was missing the variables visited alreasy my increamenting or decrementing count only once.
//2 "if(count<char_map[out]) match--;" this condition is crucial to solve the problem
// Your code here along with comments explaining your approach
//1. Create two hashmaps to keep into account the count wrt pattern and other to count the times the pattern elements are present in the string.
//2. Move fast pointer till window is formed and then move slow pointer.
//3. The window can be decremented as long as all pattern elements are present in the window.
//4. Note down the smallest window length and print it out.


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
               int count = sliding_window_count[in];
               count++; sliding_window_count[in]= count;
               if(count==char_map[in]) match++;
            //cout<<char_map[in]<<" in "<<in<<" "<<count<<endl;
             }
           
            //outgoing character
            while(match==char_map.size() && slow<=fast){ //all elements found
                //update the window
                if(window_size==-1 || window_size>(fast-slow+1)){
                    window_size=(fast-slow+1);
                    left=slow; right=fast;
                }
                //cout<<slow<<" pointers "<<fast<<" "<<endl;
                char out = s[slow];
                if(char_map.find(out)!= char_map.end()){
                    int count = sliding_window_count[out];
                    count--; sliding_window_count[out]= count;
                    if(count<char_map[out]) match--;
                }
                slow++;
            }
        }
        
        return (window_size==-1? "":s.substr(left,window_size));
    }
};
