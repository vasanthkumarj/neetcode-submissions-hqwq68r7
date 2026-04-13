class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;


        for(int pivot=0;pivot<n-2;pivot++){
           
            if(pivot > 0 && nums[pivot] == nums[pivot-1]){
              continue;
            }

            int j = pivot + 1;
            int k = n-1;

            while(j < k){

                int val = nums[pivot] + nums[j] + nums[k];

                if(val == 0){

                   result.add(Arrays.asList(nums[pivot], nums[j], nums[k]));

                   while(j < k && nums[j] == nums[j+1]){
                       j++;
                   }

                   while(k > j && nums[k] == nums[k-1]){
                       k--;
                   }

                   j++;
                   k--;

                }
                else if(val > 0){
                   k--;
                }
                else if(val < 0){
                   j++;
                }
            }
           
        }

        return result;
    }
}
