class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] output = new int[length];

        //pre
        output[0] = 1;
        for(int i = 1; i < length; i++){
            output[i] = output[i-1] * nums[i-1];
        }

        //post
        int post = 1;
        for(int i = length-1; i >= 0; i--){
            output[i] = post * output[i];
            post = post * nums[i];
        }

        return output;
    }
}  
