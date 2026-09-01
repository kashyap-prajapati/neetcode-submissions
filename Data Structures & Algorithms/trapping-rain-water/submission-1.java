class Solution {
    public int trap(int[] height) {
        int []lprefix = new int[height.length];
        int []rprefix = new int[height.length];
        lprefix[0]=height[0];
        for(int i=1;i<height.length;i++){
            lprefix[i] = Math.max(lprefix[i-1],height[i]);
        }
        rprefix[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rprefix[i] = Math.max(rprefix[i+1],height[i]);
        }

        int ans=0;
        for(int i=1;i<height.length-1;i++){
            ans = ans + Math.min(lprefix[i],rprefix[i]) - height[i];
        }
        // int ans=0;
        // for(int i=1;i<height.length-1;i++){
        //     int left = height[i];
        //     for(int k=0;k<i;k++){
        //         left = Math.max(left, height[k]);
        //     }
        //     int right=height[i];
        //     for(int k=i+1;k<height.length;k++){
        //         right = Math.max(right, height[k]);
        //     }
        //     ans = ans  + Math.min(left,right) - height[i];
        // }
        return ans;
    }
}
