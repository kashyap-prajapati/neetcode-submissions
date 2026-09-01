class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
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
