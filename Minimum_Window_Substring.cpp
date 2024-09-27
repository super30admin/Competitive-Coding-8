//Time Complexity-O(n)
//Space Complexity-O(1)--> As the Hashmap may contain maximum of 26 keys.
//Did the code execute on Leetcode? Yes

class Solution {
public:
    string minWindow(string s, string t) {
        int count=0;
        if(s.length()==0)
        {
            return "";
        }
        map<char,int>m;
        for(auto i=0;i<t.length();i++)
        {
            m[t[i]]++;
        }
        int minlen=INT_MAX,minstart=-1,minend=-1;
        int a=0,b=0;
        for(b=0;b<s.length();b++)
        {
            if(m[s[b]]>0)
            {
                count++;
            }
            m[s[b]]--;
            if(count==t.length())
            {
                while(a<b && m[s[a]]<0)
                {
                    m[s[a]]++;
                    a++;
                }
                if(minlen>b-a+1)
                {
                    minlen=b-a+1;
                    minstart=a;
                    minend=b;
                }
                m[s[a]]++;
                a++;
                count--;
            }
        }
        if(minstart==-1)
        {
            return "";
        }
        else
        {
            return s.substr(minstart,minend-minstart+1);
        }
        
    }
};