/*
TC = O(n)
SC = O(1)
where n is the size of the string s.
*/
class Solution {
public:
    int firstUniqChar(string s) {
        int i;
        int count[26]={0};
        for(i=0;i<s.length();i++)
            count[s[i]-'a']++;
        for(i=0;i<s.length();i++)
            if(count[s[i]-'a']==1){
                return i;
            }
        return -1;
    }
};
