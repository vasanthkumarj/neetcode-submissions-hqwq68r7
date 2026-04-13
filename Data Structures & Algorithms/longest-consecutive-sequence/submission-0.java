class Solution {
    public int longestConsecutive(int[] nums) {
        List<Integer> numsList = new ArrayList<>();

        for(int i : nums){
          numsList.add(i);
        }

        int longest = 0;

    
        for(int index = 0; index < nums.length; index++){
            int length = 0;
            if(!numsList.contains(nums[index]-1)){
                ++length;
                
                while(numsList.contains(nums[index]+length)){
                   ++length;
                }
            }
            longest = Math.max(longest, length);
        }

        return longest;
    }
}
