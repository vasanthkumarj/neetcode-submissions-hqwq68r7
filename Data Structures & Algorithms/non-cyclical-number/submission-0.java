class Solution {
    public boolean isHappy(int n) {

    Set<Integer> intSet = new HashSet<>();

    int sum = 0;    
        
    while(n!=0){

        System.out.println(n);
        
        int digit = n % 10; // 101  -> 1 0 1

        n = n / 10;     // 101 -> 10 -> 1 -> 0

        sum += Math.pow(digit, 2);

        if(n == 0){

           if(sum == 1){
            return true;
           }
           else if(intSet.contains(sum)){
              return false;
           }

           intSet.add(sum);

           n = sum;

           sum = 0;

        }

    }

    return false;
      

    }
}
