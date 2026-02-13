class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int n = matrix.size();
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];

        while (left <= right) {
            int mid = left+ (right-left)/2;
            int minEle = count(matrix, mid);
            if (minEle < k) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
    int count(vector<vector<int>>& matrix, int mid) {
        int rows = matrix.size();
        int j = matrix[0].size()-1;
        int count = 0;
        for(int i=0;i<rows;i++) {
            while (j>=0 && matrix[i][j] > mid) {
                j--;
            }
            count+=(j+1);
        }
        return count;
    }
};
