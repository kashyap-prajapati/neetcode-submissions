class Node{
    Node []links;
    boolean isEnd;
    String word;
    public Node(){
        links = new Node[26];
        isEnd = false;
        word = null;
    }
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    Node get(char ch){
        return links[ch-'a'];
    }

    void put(char ch, Node node){
        links[ch-'a'] = node;
    }

    void setIsEnd(){
        isEnd = true;
    }
    void switchEnd(){
        isEnd = !isEnd;
    }

    boolean isEnd(){
        return isEnd;
    }

    void setWord(String word){
        this.word =  word;
    }
    
    String getWord(){
        return this.word;
    }
}

class Trie {
    private final Node root;

    public Trie(){
        root = new Node();
    }

    private void insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setIsEnd();
        node.setWord(word);   
    }

    public void insert(String[] words){
        for(String word:words){
            insert(word);
        }
    }

    public void search(char[][] board, int i, int j, Node node, int [][] visited,List<String> temp){

        if(i<0 || j<0){
            return;
        }        

        if(i>board.length-1 || j>board[i].length-1){
            return;
        }

        if(!node.containsKey(board[i][j]) || visited[i][j]==1){
            return;
        }else{
            node = node.get(board[i][j]);
            if(node.isEnd()){
                node.switchEnd();
                temp.add(node.word);
            }
        }

        int [][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int []dir:dirs){
            visited[i][j]=1;
            search(board,i+dir[0],j+dir[1],node,visited,temp);
            visited[i][j]=0;
        }
    }

}

class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie tree = new Trie();
        tree.insert(words);
        List<String> ans = new ArrayList<>();
        int [][]visited = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                tree.search(board, i, j, tree.root,visited, ans);
            }
        }
        return ans;
    }
}
