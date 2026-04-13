class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int i : nums){
            countMap.put(i, countMap.getOrDefault(i, 0)+1);
        }

        List<Map.Entry<Integer, Integer>> sortedList  = countMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).toList();

        int[] output = new int[k];

        int i = 0;
        for(Map.Entry<Integer, Integer> entry : sortedList){
            if(i == k) break;
            output[i] = entry.getKey();
            i++;
        }

        return output;
    }
}
