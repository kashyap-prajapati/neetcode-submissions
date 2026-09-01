class Solution {
    public int maxArea(int[] heights) {

        int left=0;
        int right=heights.length-1;
        int max_area=0;
        while(left<right){
            int area=0;
            if(heights[left]<heights[right]){
                area = heights[left] * (right-left);
                left++;
            }else{
                area = heights[right] * (right-left);
                right--;
            }
            max_area=Math.max(max_area,area);
        }
        return max_area;
    }
}
