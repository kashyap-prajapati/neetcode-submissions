class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int right=piles[0];
        for(int pile:piles){
            right=Math.max(pile,right);
        }
        while(low<right){
            int mid = low + (right-low)/2;
            int hours = check(piles, mid);
            if(hours>h){
                low=mid+1;
            }else{
                right=mid;
            }
        }
        return low;            
    }

    public int check(int []piles, int k){ 
        int avg=0;
        for(int pile:piles){
  
                avg = avg + (pile+k-1)/k;
   
        }
        return avg;
    }
}
