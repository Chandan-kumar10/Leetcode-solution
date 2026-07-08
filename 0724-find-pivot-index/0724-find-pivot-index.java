class Solution {
    public int pivotIndex(int[] nums) {

        int leftsum = 0;
        int totalsum = Arrays.stream(nums).sum();
        int rightsum = totalsum;

        for(int i =0; i<nums.length; i++){

            rightsum -= nums[i];
            if(leftsum == rightsum){
                return i;
            }

            leftsum += nums[i];
        }
        return -1;
        
    }
}