class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        f(nums,0,target,temp,ans);
        return ans;

    }
    public void f(int[] nums, int index, int target, List<Integer> temp,List<List<Integer>> ans){
        if(index==nums.length){
            if(target==0){
                ans.add(new ArrayList<>(temp));
                return;
            }else{
                return;
            }
        }
        if(target>=nums[index]){
            temp.add(nums[index]);
            f(nums,index,target-nums[index],temp,ans);
            temp.remove(temp.size()-1);    
        }
        f(nums,index+1,target,temp,ans);
    }
}
