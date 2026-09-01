class Solution {
    public int climbStairs(int n) {
        return f(n);        
    }

    public int f(int index){
        if(index==0) return 1;
        if(index==1) return 1;
        return f(index-1) + f(index-2);
    }
}
