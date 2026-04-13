class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] charCount = new int[26];
        for(char c : s1.toCharArray()){
            charCount[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : charCount){
           sb.append("#").append(i);
        }

        String s1CountMap = sb.toString();

        int n = s1.length();

        for(int i = 0; i < (s2.length() - n)+1; i++){
             
             int j = i;
             int[] charCount2 = new int[26];
             while(j < (i+n)){
                 charCount2[s2.charAt(j) - 'a']++;
                 j++;
             }

            StringBuilder sb1 = new StringBuilder();
            for(int k : charCount2){
               sb1.append("#").append(k);
            }

            String s2CountMap = sb1.toString();

            if(s1CountMap.equals(s2CountMap)){
               return true;
            }


        }

        return false;

    }
}
