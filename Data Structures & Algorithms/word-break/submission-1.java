class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int []dp = new int[s.length()+1];
        dp[0]=1;
        for(int i=1;i<=s.length();i++){
            for(String word:wordDict){
                int start = i-word.length();
                if(start>=0 && dp[start]==1 && s.substring(start,start + word.length()).equals(word)){
                    dp[i]=1;
                }
            }
        }
        return dp[s.length()]==1;
        //return find(s,wordDict,0);
    }

    public boolean find(String s,List<String> wordDict, int index){

        if(index==s.length()){
            return true;
        }

        String prefix="";
        for(int i=index;i<s.length();i++){
            prefix=prefix+s.charAt(i);
            if(wordDict.contains(prefix) && find(s, wordDict, i+1)){
                return true;
            }
        }

        return false;
    }
}
