class Solution {
    public int characterReplacement(String s, int k) {
        int []count = new int[26];
        int left=0;
        int max_freq=0;
        int w_size=0;
        for(int right=0;right<s.length();right++){
            count[s.charAt(right)-'A']++;
            max_freq = Math.max(max_freq,count[s.charAt(right)-'A']);
            while(right-left+1-max_freq > k){
                count[s.charAt(left++)-'A']--;
            }
            w_size=Math.max(right-left+1,w_size);
        }        
        return w_size;

        
    }
}
