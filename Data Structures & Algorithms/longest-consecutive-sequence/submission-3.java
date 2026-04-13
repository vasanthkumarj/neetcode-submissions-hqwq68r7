class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

         Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }

        // convert to list for sorting
        List<Integer> list = new ArrayList<>(numSet);
        Collections.sort(list);

        int result = 1;
        int seqCount = 1;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1) + 1) {
                seqCount++;
                result = Math.max(result, seqCount);
            } else {
                seqCount = 1;
            }
        }
        return result;
    }
}
