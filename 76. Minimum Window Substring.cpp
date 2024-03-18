class Solution {
public:
    //Time: O(N)
    //Space: O(N)
    
    //***two pointer O(N) solution***
    //find a window that holds the required characters, then minimize from left until you still have enough characters
    //then, store the window size
    //traverse further right and find another window and repeat the process
    string minWindow(string s, string t) {
        vector<int> t_cnt(128,0);
        vector<int> s_cnt(128,0);
        
        int n1 = s.length(), n2 = t.length();

        int i=0,j=0;

        //get t count
        for(char c: t){
          t_cnt[c]++;
        }

        int found_in_window = 0;
        int ans = n1+1, st = 0;

        for(j=0;j<n1;j++){
          char c = s[j];
          s_cnt[c]++;

          //no need to increment found_in_window if s_cnt[c] > t_cnt[c], since we need only t_cnt[c] count
          if(s_cnt[c] <= t_cnt[c])  found_in_window++;

          if(found_in_window==n2){ //this window covers all the keys! try to minimize it
            
            while(found_in_window==n2){ //this loop runs only o(n) cumulative time during whole execution, so runtime is still O(n)!
              char cut = s[i];

              s_cnt[cut]--;
              i++; //minimize from left

              if(s_cnt[cut] < t_cnt[cut])  found_in_window--;
            }

            //we incremented i to one position right of the last position where it still has enough characters
            // so consider i-1 as the start index
            int found_range = j-(i-1)+1;
            if(found_range<ans){
              ans = found_range;
              st = i-1;
            }
          }

        }

        if(ans<=n1)  return s.substr(st,ans);
        return "";
    }
};
