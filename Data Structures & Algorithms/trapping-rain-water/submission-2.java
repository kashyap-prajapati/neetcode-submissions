class Solution {
    public int trap(int[] height) {
        int left=1;
        int right=height.length-2;
        int left_max = height[left-1];
        int right_max = height[right+1];
        int ans=0;
        while(left<=right){
            if(left_max<=right_max){
                ans = ans + Math.max(0,left_max-height[left]);
                left_max=Math.max(left_max,height[left]);
                left++;
            }else{
                ans = ans + Math.max(0,right_max-height[right]);
                right_max=Math.max(right_max,height[right]);
                right--;
            }

        }        
        
        
        // int []lprefix = new int[height.length];
        // int []rprefix = new int[height.length];
        // lprefix[0]=height[0];
        // for(int i=1;i<height.length;i++){
        //     lprefix[i] = Math.max(lprefix[i-1],height[i]);
        // }
        // rprefix[height.length-1]=height[height.length-1];
        // for(int i=height.length-2;i>=0;i--){
        //     rprefix[i] = Math.max(rprefix[i+1],height[i]);
        // }

        // int ans=0;
        // for(int i=1;i<height.length-1;i++){
        //     ans = ans + Math.min(lprefix[i],rprefix[i]) - height[i];
        // }
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
