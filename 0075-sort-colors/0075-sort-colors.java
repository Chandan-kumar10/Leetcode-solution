class Solution {
    public void sortColors(int[] nums) {
        int minidex = 0;
        for (int i = 0; i < nums.length; i = i + 1) {
            minidex = i;

            for (int j = i + 1; j < nums.length; j = j + 1) {
                if (nums[j] < nums[minidex]) {
                    minidex = j;
                }
            }

            int temp = nums[minidex];
            nums[minidex] = nums[i];
            nums[i] = temp;

        }

    }
}