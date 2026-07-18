class Solution {
    public int singleNumber(int[] nums) {

        int n = nums.length;

        HashMap<Integer,Integer> single = new HashMap<>();

        for(int arr : nums){

            single.put(arr, single.getOrDefault(arr, 0) +1);
        }

        for(int arr: nums){
            if(single.get(arr) == 1){
                return arr;
            }
        }

        return -1;
        
    }
}