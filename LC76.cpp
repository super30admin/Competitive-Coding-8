// Time complexity O(n)
// Space complexity (1)
class Solution {

public:
    string minWindow(string s, string t) {
        unordered_map<char, int> t_map, s_map;
        for (char c : t)
        {
            t_map[c]++;
        }

        int t_count = t_map.size();
        int s_count = 0;

        int window_min = INT_MAX;
        int window_beg = 0;

        int l = 0;
        for (int r=0; r<s.length(); r++) {
            char c = s[r];
            s_map[c]++;

            auto it = t_map.find(c);
            if (it != t_map.end())
            {
                if (s_map[c] == t_map[c])
                {
                    s_count++;
                }
            }

            // try and shrink the window.
            while (s_count == t_count)
            {
                if (r-l+1 < window_min) {
                    window_min = r-l+1;
                    window_beg = l;
                }

                char c = s[l];
                s_map[c]--;
                auto it = t_map.find(c);
                if (it != t_map.end())
                {
                    if (s_map[c] < t_map[c])
                    {
                        s_count--;
                    }
                }

                l++;
            }
        }

        if (window_min != INT_MAX)
        {
            stringstream ss;
            for (int i=window_beg; i < (window_beg+window_min); i++)
            {
                ss << s[i];
            }
            return ss.str();
        }
        
        return "";
    }
};