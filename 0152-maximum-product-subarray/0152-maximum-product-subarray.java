class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for(int i = 1; i< nums.length; i++){
            int current = nums[i];

            int tempmax = Math.max(current, Math.max(max*current, min*current));
            int tempmin = Math.min(current, Math.min(max*current, min*current));


            max = tempmax;
            min = tempmin;

            ans = Math.max(max, ans);
        }

        return ans;



        
    }

}