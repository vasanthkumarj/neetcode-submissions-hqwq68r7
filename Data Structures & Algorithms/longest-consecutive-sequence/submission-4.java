class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for(int i : nums){
            numSet.add(i);
        }

        int result = 1;

        for(int element : numSet){
            if(!numSet.contains(element-1)){
                int start = element;
                int seqCount = 1;
                while(numSet.contains(start+1)){
                    seqCount++;
                    result = Math.max(result, seqCount);
                    start += 1;
                }
            }
        }

        return result;
    }
}
