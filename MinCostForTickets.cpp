TC = O(maximum element) time and space

class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        if(days.size()==0) return 0;
        int size = days.size(); //O(1)
        int maximum = days[size-1]; //O(1)
        unordered_set<int> hash;
        for(auto day:days){
            hash.insert(day);
        }
        vector<int> dp(maximum+1); //O(maximum+1) ~ O(maximum)
        dp[0]=0; 
        for(int i=1;i<dp.size();i++){ //O(maximum) time complexity
            if(hash.find(i)==hash.end()){
                dp[i]=dp[i-1];
            }else{
                dp[i] = dp[i-1] + costs[0];

                int j = (i-7>=0) ? i-7 : 0;
                dp[i] = min(dp[i], (dp[j]+costs[1]));

                j = (i-30>=0) ? i-30 : 0;
                dp[i] = min(dp[i], (dp[j]+costs[2])); 
            }
        }
        return dp[dp.size()-1];
    }
};

