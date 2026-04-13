class Solution {
    public boolean checkValidString(String s) {
        
        int min = 0;
        int max = 0;

        for(char c : s.toCharArray()){

           if(max < 0){
             return false;
           } 

           if(min < 0){
             min = 0;
           }
           
           if(c == '('){
            min += 1;
            max += 1;
            continue;
           }

           if(c == ')'){
            min -= 1;
            max -= 1;
            continue;
           }

           if(c == '*'){
            min -= 1;
            max += 1;
           }

        }

        return min <= 0;

    }
}
