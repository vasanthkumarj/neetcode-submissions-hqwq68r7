class Solution {
    public boolean isValid(String s) {

        //Initializa stack
        Stack<Character> stack = new Stack<>();

        //iterate each characters
        for(char c : s.toCharArray()){
           
           //check for closing brace
           if(!stack.isEmpty()){

           if(c == ')'){
                if(stack.peek() == '('){
                   stack.pop();
                   continue;
                }
           }

           if(c == '}'){
                if(stack.peek() == '{'){
                   stack.pop();
                   continue;
                }
           }

           if(c == ']'){
                if(stack.peek() == '['){
                   stack.pop();
                   continue;
                }
           }

           }
        
        stack.push(c);

        }

        return stack.isEmpty();
        
    }
}
