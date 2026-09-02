class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min_stack;
    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(min_stack.isEmpty() || min_stack.peek()>=val){
            min_stack.push(val);
        }
    }
    
    public void pop() {
        int el =stack.pop();
        if(el==min_stack.peek()){
            min_stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}
