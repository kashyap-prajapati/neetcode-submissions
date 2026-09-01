class Solution {
    public int trap(int[] height) {

        int ans=0;
        for(int i=1;i<height.length-1;i++){
            int left = height[i];
            for(int k=0;k<i;k++){
                left = Math.max(left, height[k]);
            }
            int right=height[i];
            for(int k=i+1;k<height.length;k++){
                right = Math.max(right, height[k]);
            }
            ans = ans  + Math.min(left,right) - height[i];
        }
        return ans;
    }
}
