class Solution {
    public int lengthOfLongestSubstring(String s) { 
        int left=0;
        int w_size=0;
        Map<Character, Integer> map = new HashMap<>();
        for(int right=0;right<s.length();right++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right))+1,left);
            }
            map.put(s.charAt(right),right);
            w_size = Math.max(w_size,right-left+1);
        }
        return w_size;
        
    }
}
