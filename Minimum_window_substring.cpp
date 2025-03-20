// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

//Approach:
//1. We will use two pointers left and right to traverse the string.
//2. We will keep track of the frequency of characters in the string t using a hashmap t_map.
//3. We will keep track of the frequency of characters in the string s using a hashmap s_map.
//4. We will keep track of the number of characters in t that are present in the window formed by left and right pointers using a variable formed.
//5. We will keep track of the number of characters in t that are present in the window formed by left and right pointers using a variable required.
//6. We will keep track of the minimum length of the window formed by left and right pointers using a variable minLen.
//7. We will keep track of the starting index of the minimum length window using a variable minStart.
//8. We will increment the right pointer and update the s_map.
//9. If the character at right pointer is present in t_map and the frequency of the character in s_map is equal to the frequency of the character in t_map, we will increment formed.
//10. If formed is equal to required, we will update minLen and minStart.
//11. We will increment the left pointer and update the s_map.
//12. If the character at left pointer is present in s_map and the frequency of the character in s_map is less than the frequency of the character in t_map, we will decrement formed.
//13. We will continue this process until right pointer reaches the end of the string.

string minWindow(string s, string t) {
    int left = 0, right = 0; 
    unordered_map<char, int> s_map;
    unordered_map<char, int> t_map;
    for(int i = 0; i < t.size(); i++){
        t_map[t[i]]++;
    }
    int required = t_map.size();
    int formed = 0, minLen = INT_MAX, minStart = 0; 

    while(right < s.size()){
        s_map[s[right]]++;

        if(t_map.count(s[right]) == 1 && s_map[s[right]] == t_map[s[right]]){formed++;}
        while(formed == required){
            if(right - left + 1 < minLen){
                minLen = right - left + 1;
                minStart = left;
            }
            s_map[s[left]]--;
            if(s_map.count(s[left]) == 1 && s_map[s[left]] < t_map[s[left]]){
                formed--;
            }
            left++;
        }
        right++;
    }
    if(minLen == INT_MAX){return "";}
    return s.substr(minStart, minLen);
}