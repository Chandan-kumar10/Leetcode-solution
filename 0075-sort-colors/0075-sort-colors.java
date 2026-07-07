class Solution {
    public void sortColors(int[] nums) {
        
        int n = nums.length;
        int minidx = -1;

        for(int i = 0; i<n ; i++){
            minidx = i;
        

        for(int j = i+1 ; j<n; j++){
            if(nums[j] < nums[minidx]){
                minidx = j;
            }
        }
        
        int temp = nums[minidx];
        nums[minidx] = nums[i];
        nums[i] = temp;
        
        }


    }
}