class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            String k = key(str);
            System.out.println(k);
            if(map.containsKey(k)){
                ans.get(map.get(k)).add(str);
            }else{
                ans.add(new ArrayList());
                int index=ans.size()-1;
                ans.get(index).add(str);
                map.put(k,index);
            }
        }
        return ans;
    }

    public String key(String str){
        int []arr = new int[26];
        for(char c:str.toCharArray()){
           arr[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for(int i=0;i<26;i++){
            sb.append(arr[i]);
            sb.append("#");
        }
        return sb.toString();
    }
}
