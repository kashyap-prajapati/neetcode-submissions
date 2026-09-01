class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        powerset(nums,0,temp,ans);
        return ans;
    }

    public void powerset(int[] nums,int index, List<Integer> temp, List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++){
            // if(i>index &&  nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            powerset(nums,i+1,temp,ans);
            temp.remove(temp.size()-1);
        }
        // if(index==nums.length){
        //     ans.add(new ArrayList<>(temp));
        //     return;
        // }
        // temp.add(nums[index]);
        // powerset(nums,index+1,temp,ans);
        // temp.remove(temp.size()-1);
        // powerset(nums,index+1,temp,ans);
    }
}
