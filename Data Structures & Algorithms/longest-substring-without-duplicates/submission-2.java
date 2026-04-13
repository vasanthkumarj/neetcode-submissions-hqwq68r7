class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left = 0;

        Set<Character> charSet = new HashSet<>();

        int max = 0;

        int count = 0;

        for(int right = 0; right < s.length(); right++){
            
            while(charSet.contains(s.charAt(right))){
               charSet.remove(s.charAt(left));  
               left++;         
            }
            
            charSet.add(s.charAt(right));
            max = Math.max(max, charSet.size());


        }

        return max;

    }
}
