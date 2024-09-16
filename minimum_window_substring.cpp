class Solution {
public:
    string minWindow(string s, string t) {
	unordered_map<char,int>m;
	for (auto c : t)
        m[c]++;
	int left=0,right=0,counter=0,minleft=0,result=INT_MAX;
	while (right<s.size())
    {
		if (m[s[right]]>0)
			counter++;
		m[s[right]]--;
		right++;
		while (counter==t.size())
        {
			if (right-left<result)
            {
				minleft=left;
			    result=right-left;
			}
			m[s[left]]++;
			if(m[s[left]]>0)
				counter--;
			left++;
		}
	}
	if(result!=INT_MAX)
		return s.substr(minleft,result);
	return "";
}
};