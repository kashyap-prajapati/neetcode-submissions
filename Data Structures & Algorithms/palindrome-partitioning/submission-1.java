class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(s,0,temp,ans);
        return ans;
    }

     public void dfs(String s, int i, int j, List<String> temp, List<List<String>> ans){
        if(j>=s.length()){
            if(i==j){
                 ans.add(new ArrayList<>(temp));
            }
           
            return;
        }

        if(isPalindrome(s,i,j)){
            temp.add(s.substring(i,j+1));
            dfs(s,j+1,j+1,temp,ans);
            temp.remove(temp.size()-1);
        }
        dfs(s,i,j+1,temp,ans);
     }


    public void dfs(String s, int index, List<String> temp, List<List<String>> ans){
        if(index==s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index, i)){
                temp.add(s.substring(index,i+1));
                dfs(s,i+1,temp,ans);
                temp.remove(temp.size()-1);
            }
        }
    } 

    public boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


}
