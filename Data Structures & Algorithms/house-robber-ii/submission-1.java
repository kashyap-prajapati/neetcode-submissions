class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        return Math.max(f(nums, 1,nums.length),f(nums,0,nums.length-1));
    }

    public int f(int[] nums,int start,int end){
        int prev2 = 0 ;
        int prev = nums[start];
        for(int index=start;index<end;index++){
            int fs = nums[index] ;
            if(index > 1 + start) fs = fs + prev2;
            int ss = 0 + prev;
            int curr =  Math.max(fs,ss);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
