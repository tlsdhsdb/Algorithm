class MyQueue {

    private Stack<Integer> stack_in;  // 요소를 삽입하는 스택
    private Stack<Integer> stack_out; // 요소를 꺼내는 스택

    public MyQueue() {
        stack_in = new Stack<>();
        stack_out = new Stack<>();
    }
    
    public void push(int x) {
        stack_in.add(x);
    }
    
    public int pop() {

        if(stack_out.isEmpty()){
            while(!stack_in.isEmpty()){
                stack_out.add(stack_in.pop());
            }
        }

        return stack_out.pop();
    }
    
    public int peek() {
        if(stack_out.isEmpty()){
            while(!stack_in.isEmpty()){
                stack_out.add(stack_in.pop());
            }
        }
        return stack_out.peek();
    }
    
    public boolean empty() {
        return stack_out.isEmpty() && stack_in.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */