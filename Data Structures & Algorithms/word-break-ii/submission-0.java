class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        backtrack(s, wordDict, 0,"",ans);
        return ans;
    }

    public void backtrack(String s, List<String> wordDict, int index, String str, List<String> ans){
        if(index==s.length()){
            ans.add(str.substring(0,str.length()-1));
            return;
        }
        for(int j=index;j<s.length();j++){
            if(wordDict.contains(s.substring(index,j+1))){
                backtrack( s, wordDict, j+1, str + s.substring(index,j+1) + " ", ans);
            }
        }
    }
}