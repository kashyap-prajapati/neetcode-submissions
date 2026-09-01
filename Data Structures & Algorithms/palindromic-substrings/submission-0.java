class Solution {
    public int countSubstrings(String s) {
        
        // odd length palindrome
        int n=s.length();
        int count=s.length();
        for(int i=1;i<s.length()-1;i++){
            int left=i-1;
            int right=i+1;
            while(left>=0 && right<n &&  s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                count++;
            }
        }

        // even length palindrome
        for(int i=0;i<s.length()-1;i++){
            int left=i;
            int right=i+1;
            while(left>=0 && right<n &&  s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                count++;
            }
        }
        
        return count;
    }
}
