class Solution {
    public int[] countBits(int n) {
        int [] ans = new int[n+1];

        int bit_offset=1;
        ans[0] = 0;
        for(int i=1;i<=n;i++){
           if(2 * bit_offset == i ){
            bit_offset = i;
           }
           ans[i] = 1 + ans[i-bit_offset];
        }
        return ans;

    }
}
