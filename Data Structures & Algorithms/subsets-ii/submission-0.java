class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subset2(nums,0,temp,ans);
        return ans;
    }


    public void subset2(int []nums, int index, List<Integer> temp, List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++){
            if(i>index &&  nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            subset2(nums,i+1,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
}
