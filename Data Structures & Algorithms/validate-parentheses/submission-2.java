class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack =  new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else{
                if(stack.isEmpty())return false;
                char pop = stack.pop();
                if(pop=='[' && c==']'){
                    continue;
                }else if(pop=='{' && c=='}'){
                    continue;
                }else if(pop=='(' && c==')'){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty()?true:false;
    }
}
