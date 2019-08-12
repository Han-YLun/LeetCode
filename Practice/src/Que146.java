import java.util.HashMap;
import java.util.Map;

/**
 * @author: hyl
 * @date: 2019/08/11
 **/
public class Que146 {

    class LRUCache {

        Map<Integer,Node> map = new HashMap<>();
        int capacity;

        Node head = new Node(-1,-1);
        Node tail = new Node(-1,-1);


        public LRUCache(int capacity) {

            join(head,tail);
            this.capacity = capacity;
        }


        public int get(int key) {

            if (map.get(key) == null){
                return -1;
            }

            Node node = map.get(key);

            remove(node);
            moveToHead(node);

            return node.val;
        }

        public void put(int key, int value) {


            if (map.get(key) != null){
                Node node = map.get(key);
                node.val = value;
                remove(node);
                moveToHead(node);
            }else{
                if (map.size() == capacity){
                    if (tail.pre != head){
                        map.remove(tail.pre.key);
                        remove(tail.pre);
                    }
                }

                Node node = new Node(key,value);
                moveToHead(node);
                map.put(key,node);
            }

        }

        private void join(Node n1, Node n2) {

            n1.next = n2;
            n2.pre = n1;
        }


        private void remove(Node node) {

            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private void moveToHead(Node node) {

            Node next = head.next;
            join(head,node);
            join(node,next);
        }


    }

    class Node{
        Node pre;
        Node next;
        int key;
        int val;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
}
