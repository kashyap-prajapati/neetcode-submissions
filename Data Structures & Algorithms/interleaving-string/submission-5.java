class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())return false;
        return dfs(s1,s2,s3,0,0);
    }

    boolean dfs(String s1, String s2, String s3, int i, int j){
        if(i+j == s3.length()){
            return true;
        }

        if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j) &&
            i<s1.length() && s1.charAt(i)==s3.charAt(i+j)){
            return dfs(s1,s2,s3,i+1,j) || dfs(s1,s2,s3,i,j+1) ;
        }
        if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j)){
             return dfs(s1,s2,s3,i+1,j);
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j)){
            return dfs(s1,s2,s3,i,j+1);
        }
        return false;
    }

}
