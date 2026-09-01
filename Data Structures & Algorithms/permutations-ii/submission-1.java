class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
         List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //extra space
        int []visited = new int[nums.length];
        permutation(nums,temp,ans,visited);
        return ans;
    }

    public void permutation(int []nums, List<Integer> temp, List<List<Integer>> ans, int[] visited){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==1 || (i>0 && nums[i]==nums[i-1] && visited[i-1]==1))continue;
            if(visited[i]==0){
                visited[i]=1;
                temp.add(nums[i]);
                permutation(nums, temp, ans , visited);
                temp.remove(temp.size()-1);
                visited[i]=0;
            }
        }

    }

}