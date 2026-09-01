class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left=0;
        int right=matrix.length-1;
        int row=0;
        while(left<=right){
            int mid = left + (right-left)/2;
            System.out.println(mid);
            if(matrix[mid][0]==target) return true;
            if(matrix[mid][0]<=target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        row=left-1;
        if(row<0){
            return false;
        }
        left=0;
        right=matrix[row].length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(matrix[row][mid]==target) return true;
            if(matrix[row][mid]<=target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }


        return false;
    }
}
