class Solution {

    public String encode(List<String> strs) {  
        String ans = "#";                  
        for(String str:strs){
            ans  = ans + str.length() +"#"+str+"#";
        }                                             
        return ans;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='#')continue;
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
           
            int num = Integer.parseInt(str.substring(i,j));
            int index=j+1;
            ans.add(str.substring(index,index+num));
            i=index+num;
        }
        return ans;
    }
}
