//https://leetcode.com/problems/lru-cache/
class LRUCache {

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int res = -1;
        if (map.containsKey(key)) {
            Node n = map.get(key);
            res = n.value;
            remove(n);
            insertToHead(n);
        }
        return res;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            n.value = value;
            insertToHead(n);
        } else {
            Node n = new Node(key, value);
            
            if (map.size() >= capacity) {
                Node lastNode = tail.prev;
                remove(lastNode);
                insertToHead(n);
                map.remove(lastNode.key);
            } else {
                insertToHead(n);
            }
            map.put(key, n);
        }
    }
    
    public void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    public void insertToHead(Node n) {
        Node firstNode = head.next;
        head.next = n;
        n.prev = head;
        n.next = firstNode;
        firstNode.prev = n;
    }
    
    class Node {
        int key;
        int value;
        Node next, prev;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */