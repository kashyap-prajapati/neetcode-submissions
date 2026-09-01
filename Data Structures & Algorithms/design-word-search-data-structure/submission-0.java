class Node{

    private Node[] links;
    boolean flag;

    public Node(){
        links = new Node[26];
        flag = false;
    }

    Node[] getLinks(){
        return links;
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
        return flag;
    }
}
class WordDictionary {

    private static Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
       return searchWord(word, root);
    }

    public boolean searchWord(String word,Node node){
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)=='.'){
                Node []links = node.getLinks();
                for(Node link:links){
                    if(link!=null && searchWord(word.substring(i+1),link)){
                        return true;
                    }
                }
                return false;
            }else{
                if(!node.containsKey(word.charAt(i))){
                    return false;
                }
                node = node.get(word.charAt(i));
            }
        }
        return node.isEnd();
    }
}
