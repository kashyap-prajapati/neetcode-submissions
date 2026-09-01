class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // Handle a virtual "0" at the end
            int height = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() && height < heights[st.peek()]) {
                int h = heights[st.pop()];
                int width = st.isEmpty() ? i : (i - st.peek() - 1);
                maxArea = Math.max(maxArea, h * width);
            }
            st.push(i);
        }

        return maxArea;
    }
}
