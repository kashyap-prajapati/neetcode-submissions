class Node{
    Node []links;
    boolean flag;

    public Node(){
        links = new Node[26];
        flag = false;
    }

    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }

    void put(char ch, Node node){
        links[ch-'a'] = node;
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    void setEnd(){
        flag = true;
    }

    boolean isEnd(){
        return false;
    }
}

class Trie{

    private Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

}

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for(String word:dictionary){
            set.add(word);
        }
        int []dp = new int[s.length()+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return f(0,s,set,dp);
    }

    public int f(int index, String s, Set<String> set, int []dp){
        if(index==s.length()){
            return 0;
        }
        if(dp[index]!=Integer.MAX_VALUE){
            return dp[index];
        }
        int min = Integer.MAX_VALUE;
        for(int j=index+1;j<=s.length();j++){
            String sub = s.substring(index,j);
            if(set.contains(sub)){
                min = Math.min(min, f(j,s,set,dp));
            }else{
                min = Math.min(min, j-index+f(j,s,set,dp));
            }
        }
        dp[index]=min;
        return min;
    }
}



