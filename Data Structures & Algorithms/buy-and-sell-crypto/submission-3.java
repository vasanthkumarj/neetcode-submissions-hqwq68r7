class Solution {
    public int maxProfit(int[] prices) {
        
        int max = 0;

        int left = 0;
        int right = left+1;

        while(right < prices.length){
           
           if(prices[right] - prices[left] > 0){
              max = Math.max(max, prices[right] - prices[left]);
           }
           else{
             left = right;
           }
 
           right++;
        }

        return max;

    }
}
