class Solution {
    public int majorityElement(int[] nums) {
        int can = 0;
        int count = 0;
        for(int num:nums){
            if(count==0){    
                can=num;
                count=1;
            }else{
                count = (can==num ? count+1 : count-1);
            }
        }
        return can;
    }
}