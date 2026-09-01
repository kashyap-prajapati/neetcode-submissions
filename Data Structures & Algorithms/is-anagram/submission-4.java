class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int []arr = new int[26];
        for(Character c:s.toCharArray()){
            arr[c-'a']++;
        }
        for(Character c:t.toCharArray()){
            
            arr[c-'a']--;
            if(arr[c-'a']<0){
                return false;
            }
        }
        return true;

    }
}
