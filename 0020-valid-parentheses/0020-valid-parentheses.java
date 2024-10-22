class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();

        if(s.length() % 2 == 1) return false;

        for(char c : ch){
            if(c == '(' || c == '[' || c == '{') stack.add(c);
            //여는 괄호는 스택에 넣기
            else{
                if(stack.isEmpty()) return false;
                //닫는 괄호가 나올 경우 
                switch (c) {
                    case ')' : 
                    if(stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    else return false;
                    
                    
                    case ']' : 
                    if(stack.peek() == '[') {
                        stack.pop();
                        break;
                    }
                    else return false;
                    
                    
                    case '}' : 
                    if(stack.peek() == '{') {
                        stack.pop();
                        break;
                    }
                    
                    else return false;
                }
            }
        }

        if(!stack.isEmpty()) return false;
        

        return true;
    }
}