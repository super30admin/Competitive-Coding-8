// Time Complexity :O(n) 
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class NumMatrix {
    int[][] a;
    public NumMatrix(int[][] matrix) {
        
        int rows=matrix.length;
        int cols=matrix[0].length;
        a=new int[rows][cols];
        int rowsum=0;
        for(int i=0;i<rows;i++)
        {
            rowsum=0;
            for(int j=0;j<cols;j++)
            {
                rowsum+=matrix[i][j];
                a[i][j]=rowsum;
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for(int j=row1;j<=row2;j++)
        {
            int r=a[j][col2];
            if(col1!=0 && col1>0)
            {
                r=r-a[j][col1-1];
            }
                sum+=r;
        }
        
        return sum;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */