class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int target = -1;

        for(int i = n-1; i>0; i--){
            if(nums[i] > nums[i-1]){
                target = i-1;
                break;
            }
        }

        if(target != -1){
            int swaps = target;
            for(int j = n-1; j>=target +1; j--){
                if(nums[j] > nums[target]){
                    swaps = j;
                    break;
                }
            }

           swap(nums, target, swaps);
        }
           reverse(nums, target + 1, nums.length - 1);
           }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        



        }


        
    }
}