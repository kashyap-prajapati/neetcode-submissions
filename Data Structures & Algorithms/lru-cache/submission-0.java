class Node {
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class DoublLyinkedList{
    private final Node head;
    private final Node tail;

    public DoublLyinkedList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    public void addFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next =  node;
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void moveToFront(Node node){
        remove(node);
        addFront(node);
    }

    public Node removeLast(){
        if(tail.prev==head) return null;
        Node last = tail.prev;
        remove(last);
        return last;
    }

}
class LRUCache {

    private final int capacity;
    private final Map<Integer,Node> map;
    private final DoublLyinkedList dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dll = new DoublLyinkedList();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))  return -1;
        Node node = map.get(key);
        dll.moveToFront(node);
        return node.val; 
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            dll.moveToFront(node);
        }else{
            if(map.size()==this.capacity){
                Node lru = dll.removeLast();
                if(lru!=null) map.remove(lru.key);
            }
            Node n = new Node(key,value);
            dll.addFront(n);
            map.put(key, n);
        }
    }
}
