
// Time Complexity :O(n+m) m = t.length, n = s.length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// we use a tMap for strint t and a matched variable
// traverse over s
// while traversing check the character in tMap, 
// if present decrease matched and map value
// if(matched == 0)  we get an answer string
// while increaing start , we increment in map and if map value >=1 we increment matched

class Solution {
public:
    string minWindow(string s, string t) {
        int first = -1,second = -1;
        unordered_map<char,int>tMap;
        int matched = 0;
        for(int i =0;i<t.size();i++) {
            tMap[t[i]]++;
            matched++;
        }
        int start = 0;
        for(int end = 0;end<s.size();end++){
            if(tMap[s[end]]>0){
                matched--;
            }
            tMap[s[end]]--;
            while(matched == 0){
                if(first== -1 ||  (second-first+1 > end-start+1)){
                    first = start;
                    second = end;
                }
                tMap[s[start]]++;
                if(tMap[s[start]]>0) matched++;
                start++;
            }
        }
        return (first==-1)? "":s.substr(first,second-first+1);
    }
};

