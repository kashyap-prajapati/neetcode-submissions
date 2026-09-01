class Solution {
    public String longestPalindrome(String s) {
        int max=1;
        int start=0;
        int n = s.length();
        int [][] dp =  new int[n][n];
        // length 1 palindrome
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        // length 2 palindrome
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1;
                if(max==1){
                    start=i;
                    max=2;
                }
            }
        }

        // for length 2 or more
        for(int len=3;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                    dp[i][j]=1;
                    if(max<len){
                        max=len;
                        start=i;
                    }
                }
            }
        }

        return s.substring(start, start+max);

    }
}
