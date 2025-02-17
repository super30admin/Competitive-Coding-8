// Author: Subhed Chavan
// Batch: December 24
// Time Complexity: O(n log n)
// Space Complexity: O(n)

class Solution {
    public:
        int minMeetingRooms(vector<vector<int>>& intervals) {
            if(intervals.empty() || intervals.size()==0){
                return 0;
            }
    
            sort(intervals.begin(), intervals.end());
            priority_queue<int, vector<int>, greater<int>> minStore;
    
            for(int i=0;i<intervals.size();i++){
                if(!minStore.empty() && intervals[i][0]>=minStore.top()){
                    minStore.pop();
                }
                minStore.push(intervals[i][1]);
            }
    
            return minStore.size();
        }
    };