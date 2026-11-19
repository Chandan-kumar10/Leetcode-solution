class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];
            int updatecount = map.getOrDefault(current, 0) + 1;

            map.put(current, updatecount);

            if (updatecount > nums.length / 2) {
                return current;
            }

        }
        return -1;

    }
}