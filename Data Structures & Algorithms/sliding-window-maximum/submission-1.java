class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        PriorityQueue<Integer> pq
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());
        int left=0;
        int index=0;
        for(int right=0;right<nums.length;right++){
            pq.add(nums[right]);
            if(right-left+1>=k){
                ans[index++]=pq.peek();
                pq.remove(nums[left]);
                left++;
            }
        }

        return ans;


    }
}
