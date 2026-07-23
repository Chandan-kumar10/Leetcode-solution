class Solution {
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;
        int count = 0;

        for(int i = 0; i<n; i++){
            int currentsum = 0;

            for(int j = i; j<n; j++){
                currentsum += nums[j];
            

            if(currentsum == k){
                count++;
            }
        }
        }
        return count;
    }
}