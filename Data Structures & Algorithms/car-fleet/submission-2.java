class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
         int n = position.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = position[i]; 
            pairs[i][1] = speed[i];    
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Float> stack = new Stack<>();
        for(int i=0;i<pairs.length;i++){
            float time = (float)(target-pairs[i][0])/pairs[i][1];
            if(stack.isEmpty()){
                stack.add(time);
            }else{
                if(stack.peek()<time){
                    stack.add(time);
                }
            }
        }
        return stack.size();
    }
}
