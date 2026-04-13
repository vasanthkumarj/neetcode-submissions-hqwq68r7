class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            numMap.put(nums[i], i);
        }

        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++){
            int remaining = target - nums[i];
            if(numMap.containsKey(remaining) && numMap.get(remaining) != i){
                result[0] = i;
                result[1] = numMap.get(remaining);
                break;
            }
        }

        return result;
    }
}
