/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node insertAtFront(Node head, int x) {
        // code here
        Node meow = new Node(x);
        meow.next = head;
        head = meow;
        
        return head;
    }
}