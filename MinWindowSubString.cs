
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public string MinWindow(string s, string t) {
        
    int left = 0, right = 0;
    Dictionary<char, int> tMap = new Dictionary<char, int>();
    
    //creates a map of target strign that need to be find
    foreach(char ch in t)
    {
        if(tMap.ContainsKey(ch))
            tMap[ch] += 1;
        else
            tMap.Add(ch, 1);
    }
    
    string result = "";
    int match = 0;
    int minLen = Int32.MaxValue;;
    
    while(right < s.Length)
    {
        //everytime right index moves, we decrement the count in target hashmap
        //and if count equals to 0, we icnrease our mathc count, so we know how many distincy characters matched so far
        if(tMap.ContainsKey(s[right]))
        {
            tMap[s[right]] -= 1;                
            if(tMap[s[right]] == 0)
                match++;
        }
        
        //we keep invrementing left index, till we find match or target into source
        //because we need to find minimum window
        while(match == tMap.Count())
        {                
            //when we find the match, we need to check if new string is smaller than result, if yes, then replace it.        
            if(right - left + 1< minLen)
            {
                minLen = right - left + 1;
                result = s.Substring(left, minLen);
            }

            //everytime left index moves, we increase the count in target hashmap            
            if(tMap.ContainsKey(s[left]))
                tMap[s[left]] += 1;
            //if count in hasmap for any char reaches 1, we need to decrease match count
            //that means matching character from target has been moved out from source between left and right index
            if(tMap.ContainsKey(s[left]) && tMap[s[left]] == 1)
                match--;
            
            left++;
        }                
        right++;
    }
    return result;
}