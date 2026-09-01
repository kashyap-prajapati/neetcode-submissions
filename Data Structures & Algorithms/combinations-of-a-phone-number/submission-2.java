class Solution {
    public List<String> letterCombinations(String digits) {

        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String>  ans = new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        combinations(0,"",map,digits,ans);
        return ans;

    }

    public void combinations(int index, String temp, Map<Character,String> map, String digits, List<String> ans){
        if(index==digits.length()){
            ans.add(temp);
            return;
        }
        char x=digits.charAt(index);
        for(char c:map.get(x).toCharArray()){
            // temp = temp + c;
            combinations(index+1,temp+c,map,digits,ans);
            // temp = temp.substring(0,temp.length()-1);
        }

    }
}
