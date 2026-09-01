class Solution {
    public void sortColors(int[] nums) {
        int left=-1;
        int i=0;
        int right=nums.length-1;
        while(i<=right){
            if(nums[i]==0){
                left++;
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                i++;
            }else if(nums[i]==2){
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            }else{
                i++;
            }
        }

    }
}