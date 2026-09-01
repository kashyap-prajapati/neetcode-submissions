class Solution {
    public String minWindow(String s, String t) {

        int []arrt = new int[256];
        int []arrs = new int[256];
        for(char c:t.toCharArray()){
            arrt[c]++;
        }
        int count=0;
        int left=0;
        int min_len=s.length()+1;
        int index=-1;
        for(int right=0;right<s.length();right++){
            arrs[s.charAt(right)]++;

            if(arrt[s.charAt(right)]>=arrs[s.charAt(right)]){
                count++;
            }

            while(count==t.length()){
                if(right-left+1<min_len){
                    index=left;
                    min_len=right-left+1;
                }
                arrs[s.charAt(left)]--;
                if(arrt[s.charAt(left)]>arrs[s.charAt(left)]){
                    count--;
                }
               
                left++;
            }
        }
        return index==-1? "" : s.substring(index,index+min_len);       
    }
}
