package com.papa.baguwen1.baguwen1.algorithm;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution138 {
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
       if (head == null){
           return null;
       }
       return dfs(head);
    }
    Node dfs(Node node){
        if (node == null){
            return null;
        }
        if (map.containsKey(node)){
            return map.get(node);
        }
        Node copy = new Node(node.val);
        map.put(node, copy);
        copy.next = dfs(node.next);
        copy.random = dfs(node.random);
        return copy;
    }
}
