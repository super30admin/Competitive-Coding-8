// Time Complexity : O(N)
// Space Complexity : O(N)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int total = 0;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        total = helper(days, costs, 0, dp);
        return total;
    
    }

    private int helper(int[] days, int[] costs, int index, int[] dp) {
        if(index >= days.length) return 0;
        if (dp[index] != -1) return dp[index];

        int case0 = costs[0] + helper(days, costs, findNextIndex(index, days[index] + 1, days), dp);

        int case1 = costs[1] + helper(days, costs, findNextIndex(index, days[index] + 7, days), dp);

        int case2 = costs[2] + helper(days, costs, findNextIndex(index, days[index] + 30, days), dp);

        dp[index] = Math.min(case0, Math.min(case1, case2));

        return dp[index];


    }

    private int findNextIndex(int index, int lastIndexCovered, int[] days) {
        int i = index;
        while (i < days.length && days[i] < lastIndexCovered) {
            i++;
        }
        return i;
    }
}