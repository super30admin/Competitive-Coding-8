/**
 * Time complexity:
 * The time complexity is O(m +n) where
 * m is the length of the s and n is the length of t.
 */


/**
 * Space complexity:
 * O(1) because at max we are going to store 26 letters 
 * in the hash map.
 */



/**
 * Optimized Sliding Window Approach:
 * We can look for all the elements of s in t with brute force
 * and then compare the size of each substring. This will give us
 * nested iterations and time complexity will be exponential.
 * 
 * To optimize it we can think of sliding window. First, we can make 
 * a frequency map of t. Now we maitain two pointers in the string starting
 * from the 0 index. If we see a character in string which is also
 * present in the hashmap, we reduce it's frequency by 1  and inccrease
 * the match variable by 1 if the frequency of that variable becomes 0.
 * and move the fast pointer by 1. We keep on doing it until we have
 * the match == size of the frequency map. When this condition becomes
 * true we have two possible conditions. 
 * 
 * First, we have found a substring
 * where we have all the elements. Then we take the length of the substring
 * and comapre it with earlier length. Which ever is minimum we update the length
 * with that. Now, we are updating our result only when our updated length
 * is equivalent to the last caclulated substring's length.
 * 
 * Second, we have to keep on checking other possibilities too provided fast
 * and slow pointers are not equal or fast pointer is at the last index.
 * Now we have to check the element at the slow index. if it is in the hash map
 * and it's frequency is 0 we reduce the match by 1 and increase the frequency
 * by 1 and move on to the next element in the string.
 * 
 * In short, we are mnaintainig the size of window according to the incoming
 * and outgoing charcters.
 */

// The code ran perfectly on leetcode


class Solution {
public:
    string minWindow(string s, string t) {
        if(s.size() == 0 || t.size() == 0 || s.empty() || s.size() < t.size() ) return "";
        unordered_map<char, int> store;
        for(auto c : t ){
            store[c]++;
        }
        
        int i =0, j =0;
        string result = "";
        int temp = INT_MAX;
        int match = 0;
        
        while(i < s.size() && i <= j){
            if(match == store.size()){
                temp = min(temp, j - i);
                if(temp == j - i){
                    result = s.substr(i, j-i);
                }
            }
            if( (i != j && match == store.size()) || j == s.size()){
                if(store.find(s[i]) != store.end()){
                    if(store[s[i]] == 0){
                        match--;
                    }
                    store[s[i]]++;
                }
                i++;
            } else {
                if(store.find(s[j]) != store.end()){
                    store[s[j]]--;
                    if(store[s[j]] == 0){
                    match++;
                    }
                }
                j++;
            }
        }

        return result;
        
    }
};