TC:O(n) - n no.of column
SC:O(1)
Successfully run in leetcode

running sum is stored in the constructor and the sum of the area is calculated by subtracting the 
running sum at the last column with the sum at the column just before the area given.


class NumMatrix {
    int [][] mymatrix;
    public NumMatrix(int[][] matrix) {
        mymatrix = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            int rsum =0;
            for(int j=0;j<matrix[0].length;j++){
                mymatrix[i][j] = rsum + matrix[i][j];
                rsum = mymatrix[i][j];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1;i<=row2;i++){
            if(col1-1 < 0) sum = sum + mymatrix[i][col2];
            else{
                
                sum = sum + (mymatrix[i][col2] - mymatrix[i][col1-1]);
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */