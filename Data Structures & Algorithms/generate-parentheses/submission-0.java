class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n,n,"",ans,n);
        return ans;
    }

    void backtrack(int open,int close, String temp,List<String> ans,int n){
        if(temp.length()==2*n){
            ans.add(temp);
            return;
        }
        if(open>0){
            backtrack(open-1,close, temp+"(",ans,n);
        }
        if(close>open){
            backtrack(open,close-1, temp+")",ans,n);
        }
    }
}
