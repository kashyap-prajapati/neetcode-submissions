class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(n, k, 0, 1, ans, temp);
        return ans;
    }

    public void backtrack(int n, int k, int count, int index, List<List<Integer>> ans, List<Integer> temp){
        if(index==n+1){
            if(count==k){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        //take;
        temp.add(index);
        backtrack(n, k, count+1, index+1, ans, temp);
        temp.remove(temp.size()-1);
        // not take
        backtrack(n, k,count, index+1,ans,temp);

    }

}