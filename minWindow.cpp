// Time Complexity : O(n+m) // n lenght of s and m length of t 
// Space Complexity : O(1) // max 26 chars 
// Did this code succesfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Create frequency map of chars in t; Iterate through s and if char at end pointer found in map, reduce its count
// 2. Once counter is zero implies all chars of t found in window, update min len of substring
// 3. Advance start pointer till one of t's char is no longer in window and continue till end pointer reaches end of s. Return substring or ""
 

class Solution {
public:
    string minWindow(string s, string t) {
        if(s.size()==0 || t.size()==0 || s.size()<t.size())
            return "";
        map<char, int> tracker;
        for(auto c: t)
            tracker[c]++;
        int start=0,end=0,len=INT_MAX,r_start=-1,counter=tracker.size();
        string result;
        while(end<s.size()){
            if(tracker.find(s[end]) != tracker.end()){
                // s[end] found
                tracker[s[end]]--;
                if(tracker[s[end]] == 0) counter--;
            }
            end++;
            while(counter==0){
                if(end-start<len){
                    len=end-start;
                    r_start=start;
                }
                if(tracker.find(s[start]) != tracker.end()){
                    tracker[s[start]]++;
                    if(tracker[s[start]] > 0) counter++;
                }
                start++;
            }
        }
        if(r_start==-1) return "";
        result = s.substr(r_start,len);
        return result;
    }
};
