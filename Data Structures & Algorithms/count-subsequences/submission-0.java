class Solution {
    public int numDistinct(String s, String t) {
        return dfs(s,t,0,0);
    }

    int dfs(String s, String t, int i, int j){
        if(j==t.length())return 1;
        if(i==s.length())return 0;

        int not_take = dfs(s,t,i+1,j);
        int take = 0;
        if(s.charAt(i)==t.charAt(j)){
            take = dfs(s,t,i+1,j+1);
        }
        return not_take+take;

    }
}
