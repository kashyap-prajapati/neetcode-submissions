class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // one approach is to take ans of hash set and when we return that convert it to arr
        // list
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp =  new ArrayList<>();
        comb(candidates, target,0,temp,ans);
        return ans;

    }

    public void comb(int []candidates, int target, int index, 
    List<Integer> temp, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i] > target) break;
            temp.add(candidates[i]);
            comb(candidates,target-candidates[i],i+1,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
}
