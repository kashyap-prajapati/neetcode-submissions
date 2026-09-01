class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r){
        if(l<r){
            int mid = l + (r-l)/2;
            mergeSort(nums, l , mid);
            mergeSort(nums, mid+1, r);
            merge(nums, l, mid, r);
        }
       
    }

    public void merge(int[] nums, int l, int m, int r){
        int n1 = m -l + 1;
        int n2 = r - m;
        int []left = new int[n1];
        int []right = new int[n1];

        for(int i=0;i<n1;i++){
            left[i] = nums[i+l];
        }
        for(int i=0;i<n2;i++){
            right[i] = nums[m+1+i];
        }

        int i=0;
        int j=0;
        int k=l;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                nums[k] = left[i];
                i++;
            }else{
                nums[k] = right[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            nums[k] = left[i];
            i++;
            k++;
        }

        while(j<n2){
            nums[k] = right[j];
            j++;
            k++;
        }
    }
}