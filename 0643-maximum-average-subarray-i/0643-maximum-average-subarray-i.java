class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;
        int max = 0;
        int currentsum = 0;

        for(int i = 0; i<k; i++){
            sum += nums[i];

        }

            currentsum = sum;

            for(int i = k; i<nums.length; i++){
                
               sum += nums[i] - nums[i-k];
               currentsum = Math.max(sum, currentsum);
      }

      return (double) currentsum / k;

    }
}