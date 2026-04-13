class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int i : nums){
            countMap.put(i, countMap.getOrDefault(i, 0)+1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] output = new int[k];
        for(int i = 0; i < k; i++){
            output[i] = minHeap.poll()[0];
        }


        return output;
    }
}
