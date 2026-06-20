package LLD;

import java.util.HashMap;

public class LRUCache {

    Node head;
    Node tail;


    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    LRUCache(Node head ,Node tail){
        this.head = head;
        this.tail = tail;
    }

    int capacity = 20;
    HashMap<Integer,Node> cacheMap = new HashMap<>();
    // LLD.LRUCache has some capacity
    //better to go with HashMap <key,Node<Key,Value>>

    //get item
    public int getData(Node node){
        if(cacheMap.containsKey(node.key)){
            //put the taken item to starting of Node
            frontNode(node);
            return cacheMap.get(node.key).value;
        }
        else
            return -1;

    }

    public Node putData(Node node){
        if(cacheMap.containsKey(node.value)){
            
        }
        if(capacity== cacheMap.size()){
            removeNode();
        }
        frontNode(node);
        return head;
    }
    //head-tail
    public Node frontNode(Node node){
        node = head.prev;
        head.next = head;
        return head;
    }

    public Node removeNode(){
        tail.prev = null;
        tail=tail.next;
        return tail;
    }




    public static void main(String[] args) {

    }

}
