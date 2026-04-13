class Solution {
    public int characterReplacement(String s, int k) {
        
    //HashMap to store the count of each characters

    Map<Character, Integer> charCountMap = new HashMap<>();

    //initialize left pointer to 0
    int left = 0;

    //intitialize maxOccurence to 0
    int maxOccurence = 0;

    //intialize right pointer to 0;
    int right = 0;

    //start a for loop with exist condion as right is less than s.length
    int n = s.length();

    //result
    int result = 0;

    while(right < n){
      
      //add characterCount to Map
      charCountMap.put(s.charAt(right), charCountMap.getOrDefault(s.charAt(right), 0)+1);

      //update maxOccurence right after inserting the count map in order to always keep the max updated for upcoming character
      maxOccurence = Math.max(maxOccurence, charCountMap.get(s.charAt(right)));

      //check if the current substring is valid
      //length of substring - maxOccurence should not be greater than k
      while(((right - left)+1) - maxOccurence > k){
           //if the equation is more than k then we reduce the count of the character in left pointer
           charCountMap.put(s.charAt(left), charCountMap.get(s.charAt(left))-1);

           //also now we move the left pointer to check check if the substring is valid
           left++;
      }

      //result
      result = Math.max(result, (right - left)+1);

      //right increment
      right++;

    }

    return result;

    }
}
