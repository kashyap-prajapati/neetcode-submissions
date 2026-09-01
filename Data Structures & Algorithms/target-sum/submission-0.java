class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums,target,0,0);
    }   

    public int dfs(int []nums, int target, int index, int sum){
        if(index==nums.length){
            if(sum==target){
                return 1;
            }else{
                return 0;
            }
        }

        int add = dfs(nums, target,index+1,sum+nums[index]);
        int remove = dfs(nums, target, index+1,sum-nums[index]);
        return add+remove;
    }
}
