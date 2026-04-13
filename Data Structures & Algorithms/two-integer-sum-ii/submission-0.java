class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[] { -1, -1 };
        if (null == numbers || numbers.length < 2) {
            return result;
        }

        int n = numbers.length;

        int i = 0;
        int j = n - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }
            else if(sum < target){
                i++;
            }
            else{
                j--;
            }
        }

        return result;
    }
}
